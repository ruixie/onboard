package com.onboard.service.wiki.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.mapper.DocumentHistoryMapper;
import com.onboard.domain.mapper.DocumentMapper;
import com.onboard.domain.mapper.model.DocumentExample;
import com.onboard.domain.mapper.model.DocumentHistoryExample;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.DocumentHistory;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractDocumentTest {

    @Mock
    public DocumentMapper mockDocumentMapper;

    @Mock
    public DocumentHistoryMapper mockDocumentHistoryMapper;

    public static int mapperReturnValue = 1;

    @Before
    public void setupDocumentTest() {
        initDocumentMapper();
        initDocumentHistoryMapper();
    }

    public Document document;
    public DocumentExample documentExample;
    public List<Document> listOfDcoDocuments;

    public DocumentHistory documentHistory;
    public DocumentHistoryExample documentHistoryExample;
    public List<DocumentHistory> listOfDocumentHistories;

    public void initDocumentMapper() {
        document = getASampleDocument();
        documentExample = getASampleDocumentExample();
        listOfDcoDocuments = getAListofSampleDocuments();

        when(mockDocumentMapper.countByExample(Mockito.any(DocumentExample.class))).thenReturn(ModuleHelper.count);

        when(mockDocumentMapper.deleteByExample(Mockito.any(DocumentExample.class))).thenReturn(mapperReturnValue);
        when(mockDocumentMapper.deleteByPrimaryKey(ModuleHelper.id)).thenReturn(mapperReturnValue);

        when(mockDocumentMapper.insert(Mockito.any(Document.class))).thenReturn(mapperReturnValue);
        when(mockDocumentMapper.insertSelective(Mockito.any(Document.class))).thenReturn(mapperReturnValue);

        when(mockDocumentMapper.selectByExample(Mockito.any(DocumentExample.class))).thenReturn(listOfDcoDocuments);
        when(mockDocumentMapper.selectByPrimaryKey(ModuleHelper.id)).thenReturn(document);

        when(mockDocumentMapper.updateByExample(Mockito.any(Document.class), Mockito.any(DocumentExample.class))).thenReturn(
                mapperReturnValue);
        when(mockDocumentMapper.updateByExampleSelective(Mockito.any(Document.class), Mockito.any(DocumentExample.class)))
                .thenReturn(mapperReturnValue);
        when(mockDocumentMapper.updateByPrimaryKey(Mockito.any(Document.class))).thenReturn(mapperReturnValue);
        when(mockDocumentMapper.updateByPrimaryKeySelective(Mockito.any(Document.class))).thenReturn(mapperReturnValue);

    }

    public void initDocumentHistoryMapper() {
        documentHistory = getASampleDocumentHistory();
        documentHistoryExample = getASampleDocumentHistoryExample();
        listOfDocumentHistories = getAListofDocumentHistories();

        when(mockDocumentHistoryMapper.countByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(ModuleHelper.count);

        when(mockDocumentHistoryMapper.deleteByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(mapperReturnValue);
        when(mockDocumentHistoryMapper.deleteByPrimaryKey(ModuleHelper.id)).thenReturn(mapperReturnValue);

        when(mockDocumentHistoryMapper.insert(Mockito.any(DocumentHistory.class))).thenReturn(mapperReturnValue);
        when(mockDocumentHistoryMapper.insertSelective(Mockito.any(DocumentHistory.class))).thenReturn(mapperReturnValue);

        when(mockDocumentHistoryMapper.selectByExample(Mockito.any(DocumentHistoryExample.class))).thenReturn(
                listOfDocumentHistories);
        when(mockDocumentHistoryMapper.selectByPrimaryKey(ModuleHelper.id)).thenReturn(documentHistory);

        when(
                mockDocumentHistoryMapper.updateByExample(Mockito.any(DocumentHistory.class),
                        Mockito.any(DocumentHistoryExample.class))).thenReturn(mapperReturnValue);
        when(
                mockDocumentHistoryMapper.updateByExampleSelective(Mockito.any(DocumentHistory.class),
                        Mockito.any(DocumentHistoryExample.class))).thenReturn(mapperReturnValue);
        when(mockDocumentHistoryMapper.updateByPrimaryKey(Mockito.any(DocumentHistory.class))).thenReturn(mapperReturnValue);
        when(mockDocumentHistoryMapper.updateByPrimaryKeySelective(Mockito.any(DocumentHistory.class))).thenReturn(
                mapperReturnValue);

    }

    public Document getASampleDocument() {
        Document doc = new Document(false);
        doc.setId(ModuleHelper.id);
        doc.setCompanyId(ModuleHelper.companyId);
        doc.setProjectId(ModuleHelper.projectId);
        doc.setTitle(ModuleHelper.title);
        doc.setCreatorId(ModuleHelper.creatorId);
        doc.setDeleted(false);
        doc.setCreated(ModuleHelper.created);
        doc.setUpdated(ModuleHelper.updated);
        doc.setCreatorName(ModuleHelper.creatorName);
        doc.setContent(ModuleHelper.content);
        return doc;
    }

    public DocumentExample getASampleDocumentExample() {
        DocumentExample example = new DocumentExample(getASampleDocument());
        return example;
    }

    public Document getASampleDeletedDocument() {
        Document document = getASampleDocument();
        document.setDeleted(true);
        return document;
    }

    public List<Document> getAListofSampleDocuments() {
        List<Document> list = new ArrayList<Document>();
        list.add(getASampleDocument());
        list.add(getASampleDeletedDocument());
        return list;
    }

    public DocumentHistory getASampleDocumentHistory() {
        DocumentHistory dh = new DocumentHistory();

        dh.setId(ModuleHelper.id);
        dh.setContent(ModuleHelper.content);
        dh.setCreated(ModuleHelper.created);
        dh.setDocumentId(ModuleHelper.documentId);
        dh.setId(ModuleHelper.id);
        dh.setNote(ModuleHelper.note);
        dh.setProjectId(ModuleHelper.projectId);
        dh.setTitle(ModuleHelper.title);
        dh.setUpdaterId(ModuleHelper.updatorId);
        dh.setUpdaterName(ModuleHelper.updatorName);
        dh.setVersion(ModuleHelper.version);
        return dh;
    }

    public DocumentHistoryExample getASampleDocumentHistoryExample() {
        DocumentHistoryExample example = new DocumentHistoryExample(getASampleDocumentHistory());
        return example;
    }

    public List<DocumentHistory> getAListofDocumentHistories() {
        List<DocumentHistory> list = new ArrayList<DocumentHistory>();
        list.add(getASampleDocumentHistory());
        return list;
    }

}
