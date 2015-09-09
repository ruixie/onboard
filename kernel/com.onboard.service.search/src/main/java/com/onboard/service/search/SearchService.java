//package com.onboard.service.search;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 搜索服务，生成可以用户渲染页面的{@link SearchItem}列表
// * @author yewei
// *
// */
//public interface SearchService {
//
//    SearchItemList search(String key, List<Integer> projectIdList, int start, int limit, String modelType);
//
//    SearchItemList search(String key, List<Integer> projectIdList, int start, int limit);
//
//    public class SearchItemList {
//        
//        List<SearchItem> items;
//        
//        boolean hasNext;
//        
//        public SearchItemList() {
//            items = new ArrayList<SearchItem>();
//            hasNext = false;
//        }
//        
//        public List<SearchItem> getItems() {
//            return items;
//        }
//        public void setItems(List<SearchItem> items) {
//            this.items = items;
//        }
//        public boolean isHasNext() {
//            return hasNext;
//        }
//        public void setHasNext(boolean hasNext) {
//            this.hasNext = hasNext;
//        }
//        
//    }
//    
//}
