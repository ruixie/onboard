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

import java.util.ArrayList;
import java.util.List;

import org.elevenframework.web.exception.InternalServerErrorException;
import org.elevenframework.web.exception.ResourceNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.onboard.domain.mapper.model.DocumentHistoryExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.DocumentHistory;
import com.onboard.domain.model.User;
import com.onboard.service.web.SessionService;
import com.onboard.service.wiki.impl.DocumentHistoryServiceImpl;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.exampleutils.ObjectMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class DocumentHistoryServiceImplTest extends AbstractDocumentTest {

    @Mock
    private SessionService mocksSessionService;

    @InjectMocks
    private DocumentHistoryServiceImpl testeDocumentHistoryServiceImpl;

    @After
    public void afterDocumentTest() {
        Mockito.reset(mockDocumentHistoryMapper);
    }

    private void runDocHistoryAsserts(DocumentHistory history) {
        assertEquals(ModuleHelper.id, (int) history.getId());
        assertEquals(ModuleHelper.content, history.getContent());
        assertEquals(ModuleHelper.projectId, (int) history.getProjectId());
        assertEquals(ModuleHelper.created, history.getCreated());
        assertEquals(ModuleHelper.documentId, (int) history.getDocumentId());
        assertEquals(ModuleHelper.title, history.getTitle());
        assertEquals(ModuleHelper.note, history.getNote());
        assertEquals(ModuleHelper.updatorId, (int) history.getUpdaterId());
        assertEquals(ModuleHelper.updatorName, history.getUpdaterName());
        assertEquals(ModuleHelper.version, history.getVersion());
    }

    @Test
    public void testGetDocumentHistoryById() {
        DocumentHistory history = testeDocumentHistoryServiceImpl.getDocumentHistoryById(ModuleHelper.id);
        verify(mockDocumentHistoryMapper).selectByPrimaryKey(ModuleHelper.id);
        verifyNoMoreInteractions(mockDocumentHistoryMapper);
        runDocHistoryAsserts(history);
    }

    @Test
    public void testGetDocumentHistoryByVersion() {
        DocumentHistory history = testeDocumentHistoryServiceImpl.getDocumentHistoryByVersion(ModuleHelper.id,
                ModuleHelper.version);
        verify(mockDocumentMapper).selectByPrimaryKey(ModuleHelper.id);
        verify(mockDocumentHistoryMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentHistoryExample>() {
            @Override
            public boolean matches(BaseExample example) {

                return CriterionVerifier.verifyEqualTo(example, "documentId", ModuleHelper.id)
                        && CriterionVerifier.verifyEqualTo(example, "version", ModuleHelper.version);

            }
        }));
        runDocHistoryAsserts(history);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetDocumentHistoryByVersion_if_one() {
        Mockito.reset(mockDocumentMapper);
        Document d = new Document();
        d.setDeleted(true);
        when(mockDocumentMapper.selectByPrimaryKey(ModuleHelper.id)).thenReturn(d);

        testeDocumentHistoryServiceImpl.getDocumentHistoryByVersion(ModuleHelper.id, ModuleHelper.version);
        Mockito.verify(mockDocumentMapper).selectByPrimaryKey(ModuleHelper.id);

    }

    @Test(expected = InternalServerErrorException.class)
    public void testGetDocumentHistoryByVersion_if_two() {
        Mockito.reset(mockDocumentHistoryMapper);

        List<DocumentHistory> l = new ArrayList<DocumentHistory>();
        l.add(new DocumentHistory());
        l.add(new DocumentHistory());

        when(mockDocumentHistoryMapper.selectByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(l);
        testeDocumentHistoryServiceImpl.getDocumentHistoryByVersion(ModuleHelper.id, ModuleHelper.version);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetDocumentHistoryByVersion_if_three() {
        Mockito.reset(mockDocumentHistoryMapper);

        List<DocumentHistory> l = new ArrayList<DocumentHistory>();

        when(mockDocumentHistoryMapper.selectByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(l);
        testeDocumentHistoryServiceImpl.getDocumentHistoryByVersion(ModuleHelper.id, ModuleHelper.version);

    }

    @Test
    public void testGetDocumentHistoriesByDocumentId() {

        List<DocumentHistory> list = testeDocumentHistoryServiceImpl.getDocumentHistoriesByDocumentId(ModuleHelper.id,
                ModuleHelper.start, ModuleHelper.limit);

        verify(mockDocumentMapper).selectByPrimaryKey(ModuleHelper.id);
        verify(mockDocumentHistoryMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentHistoryExample>() {

            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "documentId", ModuleHelper.id)
                        && CriterionVerifier.verifyStart(example, ModuleHelper.start)
                        && CriterionVerifier.verifyLimit(example, ModuleHelper.limit);
            }
        }));

        Assert.assertEquals(1, list.size());

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetDocumentHistoriesByDocumentId_if_one() {

        reset(mockDocumentMapper);
        Document d = new Document();
        d.setDeleted(true);
        when(mockDocumentMapper.selectByPrimaryKey(ModuleHelper.documentId)).thenReturn(d);

        testeDocumentHistoryServiceImpl.getDocumentHistoriesByDocumentId(ModuleHelper.documentId, ModuleHelper.start,
                ModuleHelper.limit);
    }

    @Test
    public void testGetDocumentHistoriesByDocumentId_if_two() {
        reset(mockDocumentHistoryMapper);
        List<DocumentHistory> list = new ArrayList<DocumentHistory>();
        when(mockDocumentHistoryMapper.selectByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(list);
        when(mockDocumentMapper.selectByPrimaryKey(ModuleHelper.documentId)).thenReturn(getASampleDocument());
        User user = new User();
        user.setId(ModuleHelper.updatorId);
        user.setName(ModuleHelper.userName);
        when(mocksSessionService.getCurrentUser()).thenReturn(user);

        testeDocumentHistoryServiceImpl.getDocumentHistoriesByDocumentId(ModuleHelper.documentId, ModuleHelper.start,
                ModuleHelper.limit);
        verify(mockDocumentMapper, Mockito.times(2)).selectByPrimaryKey(ModuleHelper.documentId);
        verify(mockDocumentHistoryMapper).selectByExample(Mockito.argThat(new ExampleMatcher<DocumentHistoryExample>() {

            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "documentId", ModuleHelper.documentId)
                        && CriterionVerifier.verifyLimit(example, ModuleHelper.limit)
                        && CriterionVerifier.verifyStart(example, ModuleHelper.start);
            }
        }));

    }

    @Test
    public void testCreateDocumentHistoryDocumentHistory() {
        User user = new User();
        user.setId(ModuleHelper.updatorId);
        user.setName(ModuleHelper.userName);
        when(mocksSessionService.getCurrentUser()).thenReturn(user);

        DocumentHistory history = testeDocumentHistoryServiceImpl.createDocumentHistory(new DocumentHistory());
        verify(mockDocumentHistoryMapper).insert(Mockito.argThat(new ObjectMatcher<DocumentHistory>() {

            @Override
            public boolean verifymatches(DocumentHistory item) {
                return (item.getUpdaterId() == ModuleHelper.updatorId)
                        && ((item.getUpdaterName() == ModuleHelper.userName));
            }
        }));
        assertNotNull(history);
        assertNotNull(history.getCreated());
        assertNotNull(history.getVersion());

    }

}
