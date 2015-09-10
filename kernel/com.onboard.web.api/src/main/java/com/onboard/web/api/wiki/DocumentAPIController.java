/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.web.api.wiki;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.elevenframework.web.exception.BadRequestException;
import org.elevenframework.web.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Attachment;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.User;
import com.onboard.domain.transform.AttachmentTransform;
import com.onboard.domain.transform.DocumentTransform;
import com.onboard.dto.DocumentDTO;
import com.onboard.service.collaboration.AttachmentService;
import com.onboard.service.security.interceptors.ProjectMemberRequired;
import com.onboard.service.security.interceptors.ProjectNotArchivedRequired;
import com.onboard.service.web.SessionService;
import com.onboard.service.wiki.DocumentHistoryService;
import com.onboard.service.wiki.DocumentService;
import com.onboard.web.api.form.DocumentForm;

@RequestMapping(value = "/{companyId}/projects/{projectId}/documents")
@Controller
public class DocumentAPIController {

    public static final Logger logger = LoggerFactory.getLogger(DocumentAPIController.class);
    private static final int DOCUMENT_PER_PAGE = 30;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentHistoryService documentHistoryService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private SessionService session;

    @Autowired
    private LocalValidatorFactoryBean validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Map<String, ?> getLatestDocuments(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId) {
        List<Document> latestDocuments = documentService.getNUptodateDocuments(projectId, 3);
        List<DocumentDTO> latestDocumentDTOs = Lists
                .transform(latestDocuments, DocumentTransform.DOCUMENT_DTO_FUNCTION);
        return ImmutableMap.of("latestDocuments", latestDocumentDTOs);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Map<String, ?> getDocuments(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @RequestParam(value = "start", defaultValue = "0") Integer start) {
        if (start < 0) {
            throw new BadRequestException("parameter page shoud be positive integer.");
        }

        List<Document> documents = documentService.getDocumentsByProject(projectId, start, DOCUMENT_PER_PAGE);
        List<DocumentDTO> documentDTOs = Lists.transform(documents, DocumentTransform.DOCUMENT_DTO_FUNCTION);

        Document sample = new Document(false);
        sample.setProjectId(projectId);
        int total = documentService.countBySample(sample);

        return ImmutableMap.of("documents", documentDTOs, "total", total);
    }

    private void updateDocumentAttachment(List<Attachment> attachments, String attachType, int attachId) {
        for (Attachment attachment : attachments) {
            attachment.setAttachType(attachType);
            attachment.setAttachId(attachId);
            attachment.setTargetId(attachId);
            attachment.setTargetType(attachType);
            attachmentService.updateSelective(attachment);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Interceptors({ ProjectMemberRequired.class, ProjectNotArchivedRequired.class })
    @ResponseBody
    public Map<String, ?> createDocument(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @Valid @RequestBody DocumentForm form) {

        form.setCompanyId(companyId);
        form.setProjectId(projectId);
        form.setCreatorId(session.getCurrentUser().getId());
        form.setCreatorName(session.getCurrentUser().getName());

        Document document = documentService.create(DocumentTransform.documentDTOToDocument(form));
        documentHistoryService.createDocumentHistory(document, "新建文档");

        updateDocumentAttachment(
                Lists.transform(form.getAttachments(), AttachmentTransform.ATTACHMENTDTO_TO_ATTACHMENT_FUNCTION),
                document.getType(), document.getId());

        return ImmutableMap.of("documentDetails", document);
    }

    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Map<String, ?> showOneDocument(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("documentId") int documentId, DocumentForm form,
            Model model) {

        Document doc = documentService.getByIdWithDetail(documentId);
        return ImmutableMap.of("documentDetails", doc);
    }

    @RequestMapping(value = "/{documentId}", method = RequestMethod.PUT)
    @Interceptors({ ProjectMemberRequired.class, ProjectNotArchivedRequired.class })
    @ResponseBody
    public Map<String, ?> updateDocument(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("documentId") int documentId,
            @Valid @RequestBody DocumentForm form) {

        form.setCompanyId(companyId);
        form.setProjectId(projectId);
        form.setId(documentId);

        User user = session.getCurrentUser();
        form.setCreatorId(user.getId());
        form.setCreatorName(user.getName());

        documentService.updateSelective(DocumentTransform.documentDTOToDocument(form));

        if (form.getDeleted() != null && form.getDeleted()) {
            Document documentForDeleteHistory = documentService.getById(documentId);
            documentForDeleteHistory.setContent("");
            documentHistoryService.createDocumentHistory(documentForDeleteHistory, "删除文档");
        } else {
            documentHistoryService.createDocumentHistory(documentService.getById(documentId), form.getNote());
        }

        Document doc = documentService.getByIdWithDetail(documentId);

        updateDocumentAttachment(
                Lists.transform(form.getAttachments(), AttachmentTransform.ATTACHMENTDTO_TO_ATTACHMENT_FUNCTION),
                doc.getType(), documentId);

        return ImmutableMap.of("documentDetails", doc);
    }

    @RequestMapping(value = "/{documentId}/delete", method = RequestMethod.PUT)
    @Interceptors({ ProjectMemberRequired.class, ProjectNotArchivedRequired.class })
    @ResponseBody
    public ResponseEntity<String> deleteDocument(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("documentId") int docmentId) {

        Document document = new Document(docmentId, true);
        documentService.updateSelective(document);

        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
