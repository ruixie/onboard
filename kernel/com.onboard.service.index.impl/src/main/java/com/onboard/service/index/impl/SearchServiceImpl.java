package com.onboard.service.index.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.service.index.SearchService;
import com.onboard.service.index.model.Page;
import com.onboard.service.index.model.SearchQuery;
import com.onboard.service.index.model.SearchResult;

/**
 * 基于{@link SearchItemBuilder}的{@link SearchService}实现
 * 
 * @author yewei
 * 
 */
@Service("searchServiceBean")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private IndexServices indexServices;

    @Override
    public SearchResult search(String key, SearchQuery searchQuery, int start, int limit) {
        Page page = new Page(limit);
        page.setCurrentPageNumber(start / limit);
        return indexServices.getIndexService().search(key, searchQuery, page);
    }

}
