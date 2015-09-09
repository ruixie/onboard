//package com.onboard.service.index.impl.test;
//
//import java.util.List;
//
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.onboard.domain.model.Todo;
//import com.onboard.service.index.IndexReaderService;
//import com.onboard.service.index.IndexWriterService;
//import com.onboard.service.index.SearchResult;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/META-INF/persistence.xml", "/META-INF/test.xml" })
//public class IndexServiceTest {
//
//    @Autowired
//    private IndexWriterService indexWriter;
//
//    @Autowired
//    private IndexReaderService indexReader;
//
//    @Autowired
//    private HttpSolrServer httpSolrServer;
//
//    private int testTodoId = 1;
//
//    private int testProjectId = 1234251;
//
//    //private int testNotExistProjectId = 1234251123;
//
//    private String testContent = "test_for_search";
//
//    //private int sleep = 3000;
//
//    private Todo getTestTodo(){
//        Todo todo = new Todo();
//        todo.setId(testTodoId);
//        todo.setProjectId(testProjectId);
//        todo.setContent(testContent);
//        return todo;
//    }
//
////    private List<Integer> getProjectIdList(){
////        List<Integer> projectIdList = new ArrayList<Integer>();
////        projectIdList.add(this.testProjectId);
////        return projectIdList;
////    }
////
////    private void testAddIndexDocument() throws InterruptedException{
////        this.indexWriter.addIndexDocument(getTestTodo());
////        Thread.sleep(sleep);
////    }
////
////    private void deleteCurrentTest() throws InterruptedException{
////        this.indexWriter.deleteIndexDocumentById("todo_" + this.testTodoId);
////        Thread.sleep(sleep);
////    }
//
//    @Test
//	public void addIndexDocument() {
//    	indexWriter.addIndexDocument(this.getTestTodo());
//	}
//
//    @Test
//	public void updateIndexDocument() {
//		
//
//	}
//
//    @Test
//	public void deleteIndexDocumentById() {
//		
//
//	}
//
//    @Test
//	public void deleteIndexDocumentByIdList() {
//		
//
//	}
//
//    @Test
//	public SearchResult search() {
//		
//		return null;
//	}
//
//    @Test
//	public List<String> suggest() {
//		
//		return null;
//	}
//
//}
