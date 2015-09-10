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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.onboard.domain.mapper.model.DocumentExample;
import com.onboard.domain.mapper.model.DocumentHistoryExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Document;
import com.onboard.service.collaboration.CommentService;
import com.onboard.service.collaboration.TopicService;
import com.onboard.service.common.subscrible.SubscriberService;
import com.onboard.service.wiki.impl.DocumentServiceImpl;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.exampleutils.ObjectMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class DocumentServiceImplTest extends AbstractDocumentTest {

    @Mock
    private CommentService mockCommentService;
    @Mock
    private SubscriberService mockSubscriberService;
    @Mock
    private TopicService mockTopicService;

    @InjectMocks
    private DocumentServiceImpl testedDocumentServiceImpl;

    @After
    public void afterDocumentTest() {
        Mockito.reset(mockDocumentMapper);
    }

    private boolean verifyExample(BaseExample example, boolean deleted) {
        return CriterionVerifier.verifyEqualTo(example, "companyId", ModuleHelper.companyId)
                && CriterionVerifier.verifyEqualTo(example, "projectId", ModuleHelper.projectId)
                && CriterionVerifier.verifyEqualTo(example, "title", ModuleHelper.title)
                && CriterionVerifier.verifyEqualTo(example, "creatorId", ModuleHelper.creatorId)
                && CriterionVerifier.verifyEqualTo(example, "deleted", deleted)
                && CriterionVerifier.verifyEqualTo(example, "created", ModuleHelper.created)
                && CriterionVerifier.verifyEqualTo(example, "updated", ModuleHelper.updated)
                && CriterionVerifier.verifyEqualTo(example, "creatorName", ModuleHelper.creatorName);
    }

    private void runAsserts(Document document, boolean deleted) {
        assertEquals(ModuleHelper.id, (int) document.getId());
        assertEquals(ModuleHelper.companyId, (int) document.getCompanyId());
        assertEquals(ModuleHelper.projectId, (int) document.getProjectId());
        assertEquals(ModuleHelper.title, document.getTitle());
        assertEquals(ModuleHelper.creatorId, (int) document.getCreatorId());
        assertEquals(deleted, document.getDeleted());
        assertEquals(ModuleHelper.created, document.getCreated());
        assertEquals(ModuleHelper.updated, document.getUpdated());
        assertEquals(ModuleHelper.creatorName, document.getCreatorName());
        assertEquals(ModuleHelper.content, document.getContent());

    }

    @Test
    public void testGetDocumentById() {
        Document document = testedDocumentServiceImpl.getById(ModuleHelper.id);
        verify(mockDocumentMapper, times(1)).selectByPrimaryKey(ModuleHelper.id);
        Mockito.verifyNoMoreInteractions(mockDocumentMapper);
        runAsserts(document, false);
    }

    @Test
    public void testGetDocumentByIdWithDetail() {
        doNothing().when(mockCommentService).fillCommentable(document, 0, -1);
        doNothing().when(mockSubscriberService).fillSubcribers(document);

        Document doc = testedDocumentServiceImpl.getByIdWithDetail(ModuleHelper.id);

        verify(mockCommentService).fillCommentable(document, 0, -1);
        verify(mockSubscriberService).fillSubcribers(document);
        verify(mockDocumentMapper).selectByPrimaryKey(ModuleHelper.id);

        runAsserts(doc, false);
    }

    @Test
    public void testGetDocumentsByExample() {
        List<Document> list = testedDocumentServiceImpl.getBySample(document);

        verify(mockDocumentMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentExample>() {

            @Override
            public boolean matches(BaseExample example) {
                return verifyExample(example, false);
            }
        }));
        assertEquals(2, list.size());
        assertEquals(document, list.get(0));

        Mockito.reset(mockDocumentMapper);
    }

    @Test
    public void testGetDocumentsByProject() {

        List<Document> documents = testedDocumentServiceImpl.getDocumentsByProject(ModuleHelper.projectId, ModuleHelper.start,
                ModuleHelper.limit);
        verify(mockDocumentMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "projectId", ModuleHelper.projectId)
                        && CriterionVerifier.verifyOrderByClause(example, "updated desc")
                        && CriterionVerifier.verifyLimit(example, ModuleHelper.limit);
            }
        }));
        assertEquals(2, documents.size());
        assertEquals(document, documents.get(0));
    }

    @Test
    public void testGetDocumentsByCompanyIdBetweenDates() {

        final Date sinceDate = new DateTime(ModuleHelper.since).withTimeAtStartOfDay().toDate();
        final Date untilDate = new DateTime(ModuleHelper.until).withTimeAtStartOfDay().plusDays(1).toDate();

        List<Document> retList = testedDocumentServiceImpl.getDocumentsByCompanyIdBetweenDates(ModuleHelper.companyId,
                ModuleHelper.since, ModuleHelper.until);

        verify(mockDocumentMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentExample>() {

            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "companyId", ModuleHelper.companyId)
                        && CriterionVerifier.verifyGraterThanOrEqualTo(example, "created", sinceDate)
                        && CriterionVerifier.verifyLessThan(example, "created", untilDate);
            }
        }));

        assertNotNull(retList);
        assertEquals(2, retList.size());
        assertEquals(document, retList.get(0));

    }

    @Test
    public void testCountByExample() {
        int c = testedDocumentServiceImpl.countBySample(document);
        verify(mockDocumentMapper).countByExample(Mockito.argThat(new ExampleMatcher<DocumentExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return verifyExample(example, false);
            }
        }));

        assertEquals(ModuleHelper.count, c);
    }

    @Test
    public void testCreateDocument() {
        Document doc = testedDocumentServiceImpl.create(document);
        verify(mockDocumentMapper).insert(document);
        assertNotNull(doc);
        assertTrue(ModuleHelper.compareCreatedItemDateWithToday(doc.getCreated()));
        assertTrue(ModuleHelper.compareCreatedItemDateWithToday(doc.getUpdated()));
        assertEquals(ModuleHelper.projectId, (int) doc.getProjectId());
    }

    @Test
    public void testUpdateDocumentIfBranchOne() {
        Document srcDocument = getASampleDeletedDocument();
        DocumentServiceImpl spyDocumentServiceImpl = Mockito.spy(testedDocumentServiceImpl);
        Mockito.doReturn(document).when(spyDocumentServiceImpl).getById(ModuleHelper.id);
        Mockito.doNothing().when(mockTopicService).discardTopcicByTypeAndId(new Document().getType(), document.getId());

        Document doc = spyDocumentServiceImpl.updateSelective(srcDocument);

        verify(spyDocumentServiceImpl).getById(ModuleHelper.id);
        verify(mockDocumentMapper).updateByPrimaryKeySelective(Mockito.argThat(new ObjectMatcher<Document>() {
            @Override
            public boolean verifymatches(Document item) {
                return ModuleHelper.compareCreatedItemDateWithToday(item.getUpdated());
            }
        }));
        verify(mockTopicService).discardTopcicByTypeAndId(new Document().getType(), document.getId());
        Mockito.verifyNoMoreInteractions(mockTopicService);

        assertNotNull(doc);
        assertEquals(ModuleHelper.id, (int) doc.getId());
        assertEquals(true, doc.getDeleted());
    }

    @Test
    public void testUpdateDocumentIfBranchTwo() {
        Document retDocument = getASampleDeletedDocument();
        DocumentServiceImpl spyDocumentServiceImpl = Mockito.spy(testedDocumentServiceImpl);
        Mockito.doReturn(retDocument).when(spyDocumentServiceImpl).getById(ModuleHelper.id);
        Mockito.doNothing().when(mockTopicService).recoverTopcicByTypeAndId(new Document().getType(), document.getId());

        Document doc = spyDocumentServiceImpl.updateSelective(document);

        verify(spyDocumentServiceImpl).getById(ModuleHelper.id);
        verify(mockDocumentMapper).updateByPrimaryKeySelective(Mockito.argThat(new ObjectMatcher<Document>() {
            @Override
            public boolean verifymatches(Document item) {
                return ModuleHelper.compareCreatedItemDateWithToday(item.getUpdated());
            }
        }));
        verify(mockTopicService).recoverTopcicByTypeAndId(new Document().getType(), document.getId());
        Mockito.verifyNoMoreInteractions(mockTopicService);

        assertNotNull(doc);
        assertEquals(ModuleHelper.id, (int) doc.getId());
        assertEquals(false, doc.getDeleted());
    }

    @Test
    public void testDeleteDocument() {
        doNothing().when(mockCommentService).deleteCommentByAttachTypeAndId(new Document().getType(), ModuleHelper.id);

        testedDocumentServiceImpl.deleteFromTrash(ModuleHelper.id);

        verify(mockCommentService).deleteCommentByAttachTypeAndId(new Document().getType(), ModuleHelper.id);
        verify(mockDocumentMapper).deleteByPrimaryKey(ModuleHelper.id);
        verify(mockDocumentHistoryMapper).deleteByExample(Mockito.argThat(new ExampleMatcher<DocumentHistoryExample>() {

            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "documentId", ModuleHelper.id);
            }
        }));

    }

    @Test
    public void testDiscardDocument() {
        // covered by testUpdateDocumentIfBranchOne() and testUpdateDocumentIfBranchTwo()
    }

    @Test
    public void testRecoverDocument() {

        DocumentServiceImpl spyDocumentServiceImpl = Mockito.spy(testedDocumentServiceImpl);
        Mockito.doReturn(document).when(spyDocumentServiceImpl).updateSelective(Mockito.any(Document.class));
        doNothing().when(mockTopicService).recoverTopcicByTypeAndId(new Document().getType(), ModuleHelper.id);

        spyDocumentServiceImpl.recover(ModuleHelper.id);

        verify(mockTopicService).recoverTopcicByTypeAndId(new Document().getType(), ModuleHelper.id);
        verify(spyDocumentServiceImpl).updateSelective(Mockito.argThat(new ObjectMatcher<Document>() {

            @Override
            public boolean verifymatches(Document item) {
                return item.getDeleted() == false && item.getId() == ModuleHelper.id;
            }
        }));

    }

    @Test
    public void testGetIdentifiableById() {
        // method test was covered by existing tests
    }

}
