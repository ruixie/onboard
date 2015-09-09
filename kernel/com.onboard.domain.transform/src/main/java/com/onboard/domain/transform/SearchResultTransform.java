package com.onboard.domain.transform;

import com.google.common.collect.Lists;
import com.onboard.dto.SearchResultDTO;
import com.onboard.service.index.model.SearchResult;

public class SearchResultTransform {

    public static SearchResultDTO searchItemsToSearchResult(SearchResult searchResult) {
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        searchResultDTO.setHasNext(searchResult.isHasNext());
        if (searchResult.getResults() != null) {
            searchResultDTO.setResults(Lists.newArrayList(Lists.transform(searchResult.getResults(),
                    IndexDocumentTransForm.INDEXDOCUMENT_DTO_FUNCTION)));
        }
        return searchResultDTO;
    }
}
