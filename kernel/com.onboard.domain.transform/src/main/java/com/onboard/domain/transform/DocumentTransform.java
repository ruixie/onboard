package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Document;
import com.onboard.dto.DocumentDTO;

public class DocumentTransform {

    public static final Function<Document, DocumentDTO> DOCUMENT_DTO_FUNCTION = new Function<Document, DocumentDTO>() {
        @Override
        public DocumentDTO apply(Document input) {
            return documentToDocumentDTO(input);
        }
    };

    public static DocumentDTO documentToDocumentDTO(Document document) {
        DocumentDTO documentDTO = new DocumentDTO();
        BeanUtils.copyProperties(document, documentDTO);

        if (document.getComments() != null) {
            documentDTO.setComments(Lists.transform(document.getComments(), CommentTransform.COMMENT_TO_DTO_FUNCTION));
        }

        if (document.getSubscribers() != null) {
            documentDTO.setSubscribers(Lists.transform(document.getSubscribers(),
                    UserTransform.USER_TO_USERDTO_FUNCTION));
        }

        if (document.getAttachments() != null) {
            documentDTO.setAttachments(Lists.transform(document.getAttachments(),
                    AttachmentTransform.ATTACHMENT_TO_ATTACHMENTDTO_FUNCTION));
        }
        return documentDTO;
    }

    public static Document documentDTOToDocument(DocumentDTO documentDTO) {
        Document document = new Document();
        BeanUtils.copyProperties(documentDTO, document);

        if (documentDTO.getComments() != null) {
            document.setComments(Lists.transform(documentDTO.getComments(), CommentTransform.DTO_TO_COMMENT_FUNCTION));
        }

        if (documentDTO.getSubscribers() != null) {
            document.setSubscribers(Lists.transform(documentDTO.getSubscribers(),
                    UserTransform.USERDTO_TO_USER_FUNCTION));
        }

        if (documentDTO.getAttachments() != null) {
            document.setAttachments(Lists.transform(documentDTO.getAttachments(),
                    AttachmentTransform.ATTACHMENTDTO_TO_ATTACHMENT_FUNCTION));
        }
        return document;
    }

}
