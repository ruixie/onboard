/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.wiki.test;
//package com.onboard.plugin.wiki.test;
//
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Matchers.argThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.elevenframework.web.exception.InternalServerErrorException;
//import org.elevenframework.web.exception.ResourceNotFoundException;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;x
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.onboard.domain.mapper.common.BaseExample;
//import com.onboard.domain.model.User;
//import com.onboard.plugin.wiki.impl.DocumentHistoryServiceImpl;
//import com.onboard.plugin.wiki.mapper.DocumentHistoryExample;
//import com.onboard.plugin.wiki.mapper.DocumentHistoryMapper;
//import com.onboard.plugin.wiki.mapper.DocumentMapper;
//import com.onboard.plugin.wiki.model.Document;
//import com.onboard.plugin.wiki.model.DocumentHistory;
//import com.onboard.service.web.SessionService;
//import com.onboard.test.exampleutils.CriterionVerifier;
//import com.onboard.test.exampleutils.ExampleMatcher;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DocumentHistoryServiceTestByMockito {
//
//    @Mock
//    private DocumentHistoryMapper mockDocumentHistoryMapper;
//
//    @Mock
//    private DocumentMapper mockDocumentMapper;
//
//    @Mock
//    private DocumentHistoryExample mockDocumentHistoryExample;
//
//    @Mock
//    private SessionService mockSessionService;
//
//    @InjectMocks
//    private DocumentHistoryServiceImpl mockDocumentHistoryService;
//
//    @Test
//    public void getDocumentHistoriesByIdTest() {
//        DocumentHistory documentHistory = new DocumentHistory();
//        when(mockDocumentHistoryMapper.selectByPrimaryKey(3)).thenReturn(
//                documentHistory);
//        mockDocumentHistoryService.getDocumentHistoryById(3);
//        verify(mockDocumentHistoryMapper).selectByPrimaryKey(3);
//    }
//
//    @Test
//    public void getDocumentHistoryByVersionWithResourceNotFoundExceptionTest() {
//        try {
//            Document document = new Document(true);
//            when(mockDocumentMapper.selectByPrimaryKey(1)).thenReturn(document);
//            mockDocumentHistoryService.getDocumentHistoryByVersion(1, "");
//        } catch (ResourceNotFoundException e) {
//            Assert.assertEquals("该文档已经被删除!", e.getMessage());
//        }
//    }
//
//    @Test
//    public void getDocumentHistoryByVersionTest() {
//        Document document = new Document(false);
//        int documentId = 1;
//        String version = "";
//
//        List<DocumentHistory> mockList = mock(ArrayList.class);
//        DocumentHistory mockDocumentHistory = mock(DocumentHistory.class);
//        when(mockDocumentMapper.selectByPrimaryKey(1)).thenReturn(document);
//        when(
//                mockDocumentHistoryMapper
//                        .selectByExampleWithBLOBs(any(DocumentHistoryExample.class)))
//                .thenReturn(mockList);
//        when(mockList.size()).thenReturn(1);
//        DocumentHistory result = mockDocumentHistoryService
//                .getDocumentHistoryByVersion(documentId, version);
//        verify(mockDocumentHistoryMapper).selectByExampleWithBLOBs(
//                argThat(new ExampleMatcher<DocumentHistoryExample>() {
//
//                    @Override
//                    public boolean matches(BaseExample example) {
//                        
//                        return CriterionVerifier.verifyEqualTo(example,
//                                "documentId", 1)
//                                && CriterionVerifier.verifyEqualTo(example,
//                                        "version", "");
//                    }
//
//                }));
//        Assert.assertSame(mockList.get(0), result);
//    }
//
//    @Test(expected = InternalServerErrorException.class)
//    public void getDocumentHistoryByVersionWithSize1Test() {
//        Document document = new Document(false);
//        List<DocumentHistory> mockList = mock(ArrayList.class);
//        when(mockDocumentMapper.selectByPrimaryKey(anyInt())).thenReturn(
//                document);
//        when(
//                mockDocumentHistoryMapper
//                        .selectByExampleWithBLOBs(any(DocumentHistoryExample.class)))
//                .thenReturn(mockList);
//        when(mockList.size()).thenReturn(3);
//        mockDocumentHistoryService.getDocumentHistoryByVersion(anyInt(), "");
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void getDocumentHistoryByVersionWithSize2Test() {
//        Document document = new Document(false);
//        List<DocumentHistory> mockList = mock(ArrayList.class);
//        when(mockDocumentMapper.selectByPrimaryKey(anyInt())).thenReturn(
//                document);
//        when(
//                mockDocumentHistoryMapper
//                        .selectByExampleWithBLOBs(any(DocumentHistoryExample.class)))
//                .thenReturn(mockList);
//        when(mockList.size()).thenReturn(0);
//        mockDocumentHistoryService.getDocumentHistoryByVersion(anyInt(), "");
//    }
//
//    @Test
//    public void getDocumentHistoriesByExampleTest() {
//        DocumentHistory item = new DocumentHistory();
//        item.setDocumentId(1);
//        List<DocumentHistory> mockList = mock(ArrayList.class);
//        when(
//                mockDocumentHistoryMapper
//                        .selectByExample(argThat(new ExampleMatcher<DocumentHistoryExample>() {
//
//                            @Override
//                            public boolean matches(BaseExample example) {
//                                
//                                return CriterionVerifier.verifyEqualTo(example,
//                                        "documentId", 1);
//                            }
//
//                        }))).thenReturn(mockList);
//        List<DocumentHistory> result = mockDocumentHistoryService
//                .getDocumentHistoriesByExample(item);
//        Assert.assertSame(mockList, result);
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void getDocumentHistoriesByDocumentIdWithResourceNotFoundExceptionTest() {
//        Document document = new Document(true);
//        when(mockDocumentMapper.selectByPrimaryKey(1)).thenReturn(document);
//        mockDocumentHistoryService.getDocumentHistoriesByDocumentId(1, 1, 1);
//    }
//
//    @Test
//    public void countByExampleTest() {
//        DocumentHistory item = new DocumentHistory();
//        item.setProjectId(1);
//        when(
//                mockDocumentHistoryMapper
//                        .countByExample(argThat(new ExampleMatcher<DocumentHistoryExample>() {
//
//                            @Override
//                            public boolean matches(BaseExample example) {
//                                
//                                return CriterionVerifier.verifyEqualTo(example,
//                                        "projectId", 1);
//                            }
//
//                        }))).thenReturn(1);
//        int param = mockDocumentHistoryService.countByExample(item);
//        Assert.assertEquals(1, param);
//    }
//
//    @Test
//    public void createDocumentHistoryTest() {
//        DocumentHistory documentHistory = new DocumentHistory();
//        when(mockSessionService.getCurrentUser()).thenReturn(new User());
//        DocumentHistory result = mockDocumentHistoryService
//                .createDocumentHistory(documentHistory);
//        verify(mockDocumentHistoryMapper).insert(documentHistory);
//    }
//
//    @Test
//    public void createDocumentHistoryWithNoteTest() {
//        Document document = new Document();
//        when(mockSessionService.getCurrentUser()).thenReturn(new User());
//        DocumentHistory result = mockDocumentHistoryService
//                .createDocumentHistory(document, "");
//        Assert.assertEquals(result.getNote(), "");
//    }
//
//    @Test
//    public void sortDocumentHistoryByDateTest() {
//        List<DocumentHistory> list = new ArrayList<DocumentHistory>();
//        DocumentHistory documentHistory1 = new DocumentHistory();
//        documentHistory1.setCreated(new Date(2));
//        DocumentHistory documentHistory2 = new DocumentHistory();
//        documentHistory2.setCreated(new Date(3));
//        list.add(documentHistory1);
//        list.add(documentHistory2);
//        mockDocumentHistoryService.sortDocumentHistoryByDate(list);
//        Assert.assertSame(list.get(0), documentHistory2);
//    }
// }
