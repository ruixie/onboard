package com.onboard.domain.mapper.model;

import com.onboard.domain.mapper.model.common.BaseCriteria;
import com.onboard.domain.mapper.model.common.BaseExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrashExample implements BaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected int start = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public TrashExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
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
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public List<BaseCriteria> getOredBaseCriteria() {
        List<com.onboard.domain.mapper.model.common.BaseCriteria> list = new ArrayList<com.onboard.domain.mapper.model.common.BaseCriteria>();
        list.addAll(oredCriteria);
        return list;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void setStart(int start) {
        this.start=start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public int getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public void setLimit(int start, int limit) {
        this.start = start;
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    public TrashExample(TrashObject sample) {
        oredCriteria = new ArrayList<Criteria>();
        Criteria criteria = this.or();
        if (sample.getAttachType() != null) {
            criteria.andAttachTypeEqualTo(sample.getAttachType());
        }
        if (sample.getAttachId() != null) {
            criteria.andAttachIdEqualTo(sample.getAttachId());
        }
        if (sample.getCompanyId() != null) {
            criteria.andCompanyIdEqualTo(sample.getCompanyId());
        }
        if (sample.getProjectId() != null) {
            criteria.andProjectIdEqualTo(sample.getProjectId());
        }
        if (sample.getDeletedTime() != null) {
            criteria.andDeletedTimeEqualTo(sample.getDeletedTime());
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
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

        public Criteria andAttachTypeIsNull() {
            addCriterion("attachType is null");
            return (Criteria) this;
        }

        public Criteria andAttachTypeIsNotNull() {
            addCriterion("attachType is not null");
            return (Criteria) this;
        }

        public Criteria andAttachTypeEqualTo(String value) {
            addCriterion("attachType =", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeNotEqualTo(String value) {
            addCriterion("attachType <>", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeGreaterThan(String value) {
            addCriterion("attachType >", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attachType >=", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeLessThan(String value) {
            addCriterion("attachType <", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeLessThanOrEqualTo(String value) {
            addCriterion("attachType <=", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeLike(String value) {
            addCriterion("attachType like", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeNotLike(String value) {
            addCriterion("attachType not like", value, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeIn(List<String> values) {
            addCriterion("attachType in", values, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeNotIn(List<String> values) {
            addCriterion("attachType not in", values, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeBetween(String value1, String value2) {
            addCriterion("attachType between", value1, value2, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachTypeNotBetween(String value1, String value2) {
            addCriterion("attachType not between", value1, value2, "attachType");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNull() {
            addCriterion("attachId is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attachId is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(Integer value) {
            addCriterion("attachId =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(Integer value) {
            addCriterion("attachId <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(Integer value) {
            addCriterion("attachId >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachId >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(Integer value) {
            addCriterion("attachId <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(Integer value) {
            addCriterion("attachId <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<Integer> values) {
            addCriterion("attachId in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<Integer> values) {
            addCriterion("attachId not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(Integer value1, Integer value2) {
            addCriterion("attachId between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attachId not between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("companyId is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("companyId is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("companyId =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("companyId <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("companyId >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyId >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("companyId <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("companyId <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("companyId in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("companyId not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("companyId between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("companyId not between", value1, value2, "companyId");
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

        public Criteria andDeletedTimeIsNull() {
            addCriterion("deletedTime is null");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeIsNotNull() {
            addCriterion("deletedTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeEqualTo(Date value) {
            addCriterion("deletedTime =", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeNotEqualTo(Date value) {
            addCriterion("deletedTime <>", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeGreaterThan(Date value) {
            addCriterion("deletedTime >", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deletedTime >=", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeLessThan(Date value) {
            addCriterion("deletedTime <", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeLessThanOrEqualTo(Date value) {
            addCriterion("deletedTime <=", value, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeIn(List<Date> values) {
            addCriterion("deletedTime in", values, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeNotIn(List<Date> values) {
            addCriterion("deletedTime not in", values, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeBetween(Date value1, Date value2) {
            addCriterion("deletedTime between", value1, value2, "deletedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedTimeNotBetween(Date value1, Date value2) {
            addCriterion("deletedTime not between", value1, value2, "deletedTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trash
     *
     * @mbggenerated do_not_delete_during_merge Sat Jul 11 20:33:30 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}