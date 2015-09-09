package com.onboard.service.wiki.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.elevenframework.web.exception.InternalServerErrorException;
import org.elevenframework.web.exception.ResourceNotFoundException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.DocumentHistoryMapper;
import com.onboard.domain.mapper.DocumentMapper;
import com.onboard.domain.mapper.model.DocumentHistoryExample;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.DocumentHistory;
import com.onboard.service.web.SessionService;
import com.onboard.service.wiki.DocumentHistoryService;

/**
 * @author gourui
 */
@Transactional
@Service("documentHistoryServiceBean")
public class DocumentHistoryServiceImpl implements DocumentHistoryService {

    public static final Logger logger = LoggerFactory.getLogger(DocumentHistoryServiceImpl.class);

    public static final String DOCUMENT_DELETED_MESSAGE = "该文档已经被删除!";
    @Autowired
    private DocumentHistoryMapper documentHistoryMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private SessionService sessionService;

    @Override
    public DocumentHistory getDocumentHistoryById(int id) {
        DocumentHistory documentHistory = documentHistoryMapper.selectByPrimaryKey(id);
        return documentHistory;
    }

    @Override
    public DocumentHistory getDocumentHistoryByVersion(int documentId, String version) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        if (document.getDeleted()) {
            throw new ResourceNotFoundException(DOCUMENT_DELETED_MESSAGE);
        }

        DocumentHistory dh = new DocumentHistory();
        dh.setDocumentId(documentId);
        dh.setVersion(version);

        DocumentHistoryExample example = new DocumentHistoryExample(dh);
        List<DocumentHistory> list = documentHistoryMapper.selectByExample(example);

        if (list.size() > 1) {
            throw new InternalServerErrorException("duplicated version of document:" + documentId);
        }

        if (list.size() == 0) {
            throw new ResourceNotFoundException("版本号对应的文档历史不存在!");
        }

        return list.get(0);
    }

    @Override
    public List<DocumentHistory> getDocumentHistoriesByDocumentId(int documentId, int start, int limit) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        if (document.getDeleted()) {
            throw new ResourceNotFoundException(DOCUMENT_DELETED_MESSAGE);
        }

        DocumentHistory documentHistory = new DocumentHistory();
        documentHistory.setDocumentId(documentId);
        DocumentHistoryExample documentHistoryExample = new DocumentHistoryExample(documentHistory);
        documentHistoryExample.setLimit(start, limit);

        List<DocumentHistory> dhs = documentHistoryMapper.selectByExample(documentHistoryExample);
        if (dhs.size() == 0) {
            dhs.add(createDocumentHistory(documentMapper.selectByPrimaryKey(documentId), "新建文档"));
        }
        sortDocumentHistoryByDate(dhs);

        return dhs;
    }

    @Override
    public DocumentHistory createDocumentHistory(DocumentHistory documentHistory) {
        Date now = new Date();
        documentHistory.setCreated(now);
        documentHistory.setUpdaterId(sessionService.getCurrentUser().getId());
        documentHistory.setUpdaterName(sessionService.getCurrentUser().getName());
        ;
        documentHistory.setVersion(DateTimeFormat.forPattern("yyyyMMddHHmmssSS").print(new DateTime()));

        documentHistoryMapper.insert(documentHistory);
        return documentHistory;
    }

    @Override
    public DocumentHistory createDocumentHistory(Document document, String note) {
        DocumentHistory documentHistory = new DocumentHistory();
        documentHistory.setContent(document.getContent());
        documentHistory.setTitle(document.getTitle());
        documentHistory.setProjectId(document.getProjectId());
        documentHistory.setDocumentId(document.getId());
        documentHistory.setNote(note);

        return createDocumentHistory(documentHistory);
    }

    @Override
    /**
     * Modify by: Dongdong Du
     * Sort the Document history by created date descending. 
     */
    public void sortDocumentHistoryByDate(List<DocumentHistory> list) {
        Collections.sort(list, new Comparator<DocumentHistory>() {
            @Override
            public int compare(DocumentHistory o1, DocumentHistory o2) {
                // sort by created date descending
                return o2.getCreated().compareTo(o1.getCreated());
            }
        });
    }

}
