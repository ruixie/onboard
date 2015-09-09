package com.onboard.dto;

import java.util.List;

public class SearchResultDTO {

    private List<IndexDocumentDTO> indexDocumentDTOs;
    private boolean hasNext;

    public List<IndexDocumentDTO> getResults() {
        return indexDocumentDTOs;
    }

    public void setResults(List<IndexDocumentDTO> indexDocumentDTOs) {
        this.indexDocumentDTOs = indexDocumentDTOs;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

}
