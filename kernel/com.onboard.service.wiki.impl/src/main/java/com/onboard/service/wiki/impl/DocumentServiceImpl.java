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
package com.onboard.service.wiki.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.DocumentHistoryMapper;
import com.onboard.domain.mapper.DocumentMapper;
import com.onboard.domain.mapper.base.BaseMapper;
import com.onboard.domain.mapper.model.DocumentExample;
import com.onboard.domain.mapper.model.DocumentHistoryExample;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.DocumentHistory;
import com.onboard.service.account.UserService;
import com.onboard.service.base.AbstractBaseService;
import com.onboard.service.collaboration.CommentService;
import com.onboard.service.collaboration.TopicService;
import com.onboard.service.common.subscrible.SubscriberService;
import com.onboard.service.wiki.DocumentService;

/**
 * {@link DocumentService}接口实现
 * 
 * @author yewei, completed by gourui
 * 
 */
@Transactional
@Service("documentServiceBean")
public class DocumentServiceImpl extends AbstractBaseService<Document, DocumentExample> implements DocumentService {

    public static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

    public static final int DEFAULT_LIMIT = -1;

    public static final int LOCK_EXPIRE_SECONDS = 10;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentHistoryMapper documentHistoryMapper;

    @Value("${plugins.document.defaultTitle}")
    private String defaultTitle;

    @Value("${plugins.document.defaultContent}")
    private String defaultContent;

    @Override
    public Document getByIdWithDetail(int id) {
        Document document = documentMapper.selectByPrimaryKey(id);
        commentService.fillCommentable(document, 0, DEFAULT_LIMIT);
        subscriberService.fillSubcribers(document);
        return document;
    }

    @Override
    public List<Document> getDocumentsByProject(int projectId, int start, int limit) {
        Document document = new Document(false);
        document.setProjectId(projectId);
        DocumentExample documentExample = new DocumentExample(document);
        documentExample.setOrderByClause("updated desc");
        documentExample.setLimit(start, limit);
        List<Document> list = documentMapper.selectByExample(documentExample);
        return list;
    }

    @Override
    public List<Document> getDocumentsByCompanyIdBetweenDates(int companyId, Date since, Date until) {
        Document document = new Document();
        document.setCompanyId(companyId);
        DocumentExample documentExmaple = new DocumentExample(document);

        DateTime dt = new DateTime(since);
        since = dt.withTimeAtStartOfDay().toDate();
        dt = new DateTime(until);
        until = dt.withTimeAtStartOfDay().plusDays(1).toDate();

        documentExmaple.getOredCriteria().get(0).andCreatedGreaterThanOrEqualTo(since).andCreatedLessThan(until);
        return documentMapper.selectByExample(documentExmaple);
    }

    @Override
    public Document create(Document document) {
        document.setDeleted(false);
        if (document.getIsHomePage() == null) {
            document.setIsHomePage(false);
        }
        document.setCreated(new Date());
        document.setUpdated(document.getCreated());
        documentMapper.insert(document);
        return document;
    }

    @Override
    public Document updateSelective(Document document) {
        Document srcDocument = getById(document.getId());
        document.setUpdated(new Date());
        documentMapper.updateByPrimaryKeySelective(document);
        if (document.getDeleted() != null && document.getDeleted()) {
            topicService.discardTopcicByTypeAndId(document.getType(), document.getId());
        } else if (srcDocument.getDeleted() != null && srcDocument.getDeleted() && !document.getDeleted()) {
            topicService.recoverTopcicByTypeAndId(document.getType(), document.getId());
        }
        return document;
    }

    @Override
    public void deleteFromTrash(int id) {
        commentService.deleteCommentByAttachTypeAndId(new Document().getType(), id);
        DocumentHistory documentHistory = new DocumentHistory();
        documentHistory.setDocumentId(id);
        documentHistoryMapper.deleteByExample(new DocumentHistoryExample(documentHistory));
        documentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delete(int id) {
        Document document = new Document(id, true);
        updateSelective(document);
    }

    @Override
    public void recover(int id) {
        Document document = new Document(id, false);
        topicService.recoverTopcicByTypeAndId(document.getType(), id);
        updateSelective(document);
    }

    @Override
    public List<Document> getNUptodateDocuments(int projectId, int n) {
    	// TODO 这个实现不太好，应该可以直接按Date排序获取n个文档
        Document document = new Document(false);
        document.setProjectId(projectId);
        List<Document> list = getBySample(document);
        sortDocumentsByDate(list);

        n = n < list.size() ? n : list.size();
        list = list.subList(0, n);
        List<Document> resultList = new ArrayList<Document>(n);
        for (int i = 0; i < n; i++) {
            Document d = getByIdWithDetail(list.get(i).getId());
            resultList.add(d);
        }
        return resultList;
    }

    private void sortDocumentsByDate(List<Document> list) {
        Collections.sort(list, new Comparator<Document>() {
            @Override
            public int compare(Document o1, Document o2) {
                return o2.getUpdated().compareTo(o1.getUpdated());
            }
        });
    }

    @Override
    protected BaseMapper<Document, DocumentExample> getBaseMapper() {
        return documentMapper;
    }

    @Override
    public Document newItem() {
        return new Document();
    }

    @Override
    public DocumentExample newExample() {
        return new DocumentExample();
    }

    @Override
    public DocumentExample newExample(Document item) {
        return new DocumentExample(item);
    }

}
