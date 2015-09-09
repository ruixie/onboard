package com.onboard.domain.transform;

import com.google.common.base.Function;
import com.onboard.dto.IndexDocumentDTO;
import com.onboard.service.index.model.IndexDocument;

public class IndexDocumentTransForm {
    public static final Function<IndexDocument, IndexDocumentDTO> INDEXDOCUMENT_DTO_FUNCTION = new Function<IndexDocument, IndexDocumentDTO>() {
        @Override
        public IndexDocumentDTO apply(IndexDocument input) {
            return indexDocumentToIndexDocumentDTO(input);
        }
    };

    public static IndexDocumentDTO indexDocumentToIndexDocumentDTO(IndexDocument indexDocument) {
        IndexDocumentDTO indexDocumentDTO = new IndexDocumentDTO();
        indexDocumentDTO.setCompanyId(indexDocument.getCompanyId());
        indexDocumentDTO.setContent(indexDocument.getContent());
        indexDocumentDTO.setCreatedTime(indexDocument.getCreatedTime());
        indexDocumentDTO.setCreatorAvatar(indexDocument.getCreatorAvatar());
        indexDocumentDTO.setCreatorId(indexDocument.getCreatorId());
        indexDocumentDTO.setCreatorName(indexDocument.getCreatorName());
        indexDocumentDTO.setModelId(indexDocument.getModelId());
        indexDocumentDTO.setModelType(indexDocument.getModelType());
        indexDocumentDTO.setProjectId(indexDocument.getProjectId());
        indexDocumentDTO.setProjectName(indexDocument.getProjectName());
        indexDocumentDTO.setRelatorIds(indexDocument.getRelatorIds());
        indexDocumentDTO.setTitle(indexDocument.getTitle());
        indexDocumentDTO.setExtendIndexFileds(indexDocument.getExtendIndexFields());
        return indexDocumentDTO;
    }

}
