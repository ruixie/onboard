package com.onboard.service.index;

import com.onboard.service.index.model.SearchQuery;
import com.onboard.service.index.model.SearchResult;

public interface SearchService {
    
    SearchResult search(String key, SearchQuery searchQuery, int start, int limit);


}
