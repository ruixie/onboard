package com.onboard.service.index.model;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 查询结果
 * 
 * @author lvyiqiang
 * 
 */
public class SearchResult {
    
    private List<IndexDocument> indexDocumentList = Lists.newArrayList();
    
    private boolean hasNext;

    public List<IndexDocument> getResults() {
        return indexDocumentList;
    }

    public void setResults(List<IndexDocument> indexDocumentList) {
        this.indexDocumentList = indexDocumentList;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
