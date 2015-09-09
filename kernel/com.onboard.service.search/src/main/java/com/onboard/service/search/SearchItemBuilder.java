//package com.onboard.service.search;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.onboard.domain.model.type.IdentifiableOperator;
//import com.onboard.domain.model.type.Indexable;
//import com.onboard.service.common.identifiable.IdentifiableManager;
//import com.onboard.service.index.model.IndexDocument;
//import com.onboard.service.index.model.SearchResult;
//
///**
// * 构造搜索对象的辅助类
// * 
// * @author yewei
// * 
// */
//public abstract class SearchItemBuilder implements IdentifiableOperator {
//
//    @Autowired
//    IdentifiableManager identifiableManager;
//
//    protected String getItemUrl(Indexable indexable) {
//        return identifiableManager.getIdentifiableURL(indexable);
//    }
//
//    protected abstract Indexable indexableInstance(int id);
//
//    protected String getItemName(Indexable indexable) {
//        return null;
//    }
//
//    protected String getContent(Indexable indexable) {
//        return null;
//    }
//
//    protected void fillExtraInfo(SearchItem searchItem, Indexable indexable, Map<String, List<String>> highLightingMap) {
//        // do nothing
//    }
//
//    public List<SearchItem> buildItemFromIndexResult(SearchResult searchResult) {
//        List<SearchItem> result = new ArrayList<SearchItem>();
//
//        List<IndexDocument> IndexDocumentList = searchResult.getResults();
//        for (IndexDocument document : IndexDocumentList) {
//            String id = document.getId();
//            Map<String, List<String>> map = searchResult.getHighLightingMap().get(id);
//            result.add(this.buildItemFromIndexDocument(document, map));
//        }
//
//        return result;
//    }
//
//    public SearchItem buildItemFromIndexDocument(IndexDocument indexDocument, Map<String, List<String>> highLightingMap) {
//
//        String itemId = SearchItemBuilderUtils.getItemId(indexDocument);
//        Indexable indexable = this.indexableInstance(Integer.parseInt(itemId));
//        if (indexable == null) {
//            return null;
//        }
//
//        SearchItem searchItem = new SearchItem();
//        searchItem.setDate(indexable.getUpdated());
//        searchItem.setProjectName(SearchItemBuilderUtils.getProjectName(indexable.getProjectId()));
//        searchItem.setProjectId(indexable.getProjectId());
//        searchItem.setType(indexable.getType());
//        searchItem.setUserId(indexable.getCreatorId());
//        searchItem.setUserName(indexable.getCreatorName());
//        searchItem.setId(indexable.getId());
//
//        String itemNameIndexFiled = indexable.itemNameIndexFiled();
//        if (itemNameIndexFiled != null && highLightingMap.get(itemNameIndexFiled) != null
//                && !highLightingMap.get(itemNameIndexFiled).isEmpty()) {
//            searchItem.setItemName(highLightingMap.get(itemNameIndexFiled).get(0));
//        }
//
//        String itemContentIndexFiled = indexable.itemContentIndexFiled();
//        if (itemContentIndexFiled != null && highLightingMap.get(itemContentIndexFiled) != null
//                && !highLightingMap.get(itemContentIndexFiled).isEmpty()) {
//            searchItem.setContent(highLightingMap.get(itemContentIndexFiled).get(0));
//        }
//
//        if (searchItem.getContent() == null) {
//            searchItem.setContent(this.getContent(indexable));
//        }
//        if (searchItem.getItemName() == null) {
//            searchItem.setItemName(this.getItemName(indexable));
//        }
//        searchItem.setItemUrl(this.getItemUrl(indexable));
//
//        this.fillExtraInfo(searchItem, indexable, highLightingMap);
//
//        return searchItem;
//    }
//}
