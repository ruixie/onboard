package com.onboard.domain.mapper.model;

import com.onboard.domain.mapper.model.common.BaseCriteria;
import com.onboard.domain.mapper.model.common.BaseExample;

import java.util.ArrayList;
import java.util.List;

public class AttachTodoExample implements BaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int start = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public AttachTodoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
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
     * This method corresponds to the database table attach_todo
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
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
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
     * This method corresponds to the database table attach_todo
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
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setStart(int start) {
        this.start=start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int start, int limit) {
        this.start = start;
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attach_todo
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public AttachTodoExample(AttachTodoObject sample) {
        oredCriteria = new ArrayList<Criteria>();
        Criteria criteria = this.or();
        if (sample.getAttachType() != null) {
            criteria.andAttachTypeEqualTo(sample.getAttachType());
        }
        if (sample.getAttachId() != null) {
            criteria.andAttachIdEqualTo(sample.getAttachId());
        }
        if (sample.getTodoId() != null) {
            criteria.andTodoIdEqualTo(sample.getTodoId());
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table attach_todo
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

        public Criteria andTodoIdIsNull() {
            addCriterion("todoId is null");
            return (Criteria) this;
        }

        public Criteria andTodoIdIsNotNull() {
            addCriterion("todoId is not null");
            return (Criteria) this;
        }

        public Criteria andTodoIdEqualTo(Integer value) {
            addCriterion("todoId =", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotEqualTo(Integer value) {
            addCriterion("todoId <>", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdGreaterThan(Integer value) {
            addCriterion("todoId >", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("todoId >=", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdLessThan(Integer value) {
            addCriterion("todoId <", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdLessThanOrEqualTo(Integer value) {
            addCriterion("todoId <=", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdIn(List<Integer> values) {
            addCriterion("todoId in", values, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotIn(List<Integer> values) {
            addCriterion("todoId not in", values, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdBetween(Integer value1, Integer value2) {
            addCriterion("todoId between", value1, value2, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("todoId not between", value1, value2, "todoId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table attach_todo
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 26 19:51:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}