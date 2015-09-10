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
package com.onboard.domain.mapper.model;

import com.onboard.domain.mapper.model.common.BaseCriteria;
import com.onboard.domain.mapper.model.common.BaseExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentHistoryExample implements BaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int start = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public List<BaseCriteria> getOredBaseCriteria() {
        List<com.onboard.domain.mapper.model.common.BaseCriteria> list = new ArrayList<com.onboard.domain.mapper.model.common.BaseCriteria>();
        list.addAll(oredCriteria);
        return list;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setStart(int start) {
        this.start=start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int start, int limit) {
        this.start = start;
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentHistoryExample(DocumentHistoryObject sample) {
        oredCriteria = new ArrayList<Criteria>();
        Criteria criteria = this.or();
        if (sample.getDocumentId() != null) {
            criteria.andDocumentIdEqualTo(sample.getDocumentId());
        }
        if (sample.getVersion() != null) {
            criteria.andVersionEqualTo(sample.getVersion());
        }
        if (sample.getUpdaterId() != null) {
            criteria.andUpdaterIdEqualTo(sample.getUpdaterId());
        }
        if (sample.getUpdaterName() != null) {
            criteria.andUpdaterNameEqualTo(sample.getUpdaterName());
        }
        if (sample.getCreated() != null) {
            criteria.andCreatedEqualTo(sample.getCreated());
        }
        if (sample.getNote() != null) {
            criteria.andNoteEqualTo(sample.getNote());
        }
        if (sample.getProjectId() != null) {
            criteria.andProjectIdEqualTo(sample.getProjectId());
        }
        if (sample.getTitle() != null) {
            criteria.andTitleEqualTo(sample.getTitle());
        }
        if (sample.getContent() != null) {
            criteria.andContentEqualTo(sample.getContent());
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table document_history
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNull() {
            addCriterion("documentId is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("documentId is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(Integer value) {
            addCriterion("documentId =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(Integer value) {
            addCriterion("documentId <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(Integer value) {
            addCriterion("documentId >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("documentId >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(Integer value) {
            addCriterion("documentId <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(Integer value) {
            addCriterion("documentId <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(List<Integer> values) {
            addCriterion("documentId in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(List<Integer> values) {
            addCriterion("documentId not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(Integer value1, Integer value2) {
            addCriterion("documentId between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("documentId not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNull() {
            addCriterion("updaterId is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNotNull() {
            addCriterion("updaterId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdEqualTo(Integer value) {
            addCriterion("updaterId =", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotEqualTo(Integer value) {
            addCriterion("updaterId <>", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThan(Integer value) {
            addCriterion("updaterId >", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("updaterId >=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThan(Integer value) {
            addCriterion("updaterId <", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("updaterId <=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIn(List<Integer> values) {
            addCriterion("updaterId in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotIn(List<Integer> values) {
            addCriterion("updaterId not in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdBetween(Integer value1, Integer value2) {
            addCriterion("updaterId between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("updaterId not between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameIsNull() {
            addCriterion("updaterName is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameIsNotNull() {
            addCriterion("updaterName is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameEqualTo(String value) {
            addCriterion("updaterName =", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameNotEqualTo(String value) {
            addCriterion("updaterName <>", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameGreaterThan(String value) {
            addCriterion("updaterName >", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("updaterName >=", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameLessThan(String value) {
            addCriterion("updaterName <", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameLessThanOrEqualTo(String value) {
            addCriterion("updaterName <=", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameLike(String value) {
            addCriterion("updaterName like", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameNotLike(String value) {
            addCriterion("updaterName not like", value, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameIn(List<String> values) {
            addCriterion("updaterName in", values, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameNotIn(List<String> values) {
            addCriterion("updaterName not in", values, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameBetween(String value1, String value2) {
            addCriterion("updaterName between", value1, value2, "updaterName");
            return (Criteria) this;
        }

        public Criteria andUpdaterNameNotBetween(String value1, String value2) {
            addCriterion("updaterName not between", value1, value2, "updaterName");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("projectId is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("projectId is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("projectId =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("projectId <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("projectId >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectId >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("projectId <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("projectId <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("projectId in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("projectId not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("projectId between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("projectId not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table document_history
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 26 19:51:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}