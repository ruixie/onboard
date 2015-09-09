package com.onboard.web.api.wiki;

import java.util.List;
import java.util.Map;

import org.elevenframework.web.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;
import com.onboard.domain.model.DocumentHistory;
import com.onboard.service.security.interceptors.ProjectMemberRequired;
import com.onboard.service.wiki.DocumentHistoryService;

@RequestMapping(value = "/{companyId}/projects/{projectId}/documents")
@Controller
public class DocumentHistoryAPIController {

    public static final Logger logger = LoggerFactory.getLogger(DocumentHistoryAPIController.class);

    @Autowired
    private DocumentHistoryService documentHistoryService;

    @RequestMapping(value = "/{documentId}/history", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Map<String, ?> getDocumentHistories(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("documentId") int documentId, Model model) {

        List<DocumentHistory> dhs = documentHistoryService.getDocumentHistoriesByDocumentId(documentId, 0, -1);
        return ImmutableMap.of("documentHistories", dhs);
    }

    @RequestMapping(value = "/{documentId}/{version}", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Map<String, ?> getDocumentHistory(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("documentId") int documentId,
            @PathVariable("version") String version, Model model) {

        DocumentHistory documentHistory = documentHistoryService.getDocumentHistoryByVersion(documentId, version);

        return ImmutableMap.of("documentHistoryInfo", documentHistory);
    }

}
