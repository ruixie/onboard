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
import java.util.List;

public class UserCompanyExample implements BaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int start = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public UserCompanyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
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
     * This method corresponds to the database table user_company
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
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
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
     * This method corresponds to the database table user_company
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
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setStart(int start) {
        this.start=start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLimit(int start, int limit) {
        this.start = start;
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public UserCompanyExample(UserCompanyObject sample) {
        oredCriteria = new ArrayList<Criteria>();
        Criteria criteria = this.or();
        if (sample.getUserId() != null) {
            criteria.andUserIdEqualTo(sample.getUserId());
        }
        if (sample.getCompanyId() != null) {
            criteria.andCompanyIdEqualTo(sample.getCompanyId());
        }
        if (sample.getGroupId() != null) {
            criteria.andGroupIdEqualTo(sample.getGroupId());
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_company
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

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
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

        public Criteria andGroupIdIsNull() {
            addCriterion("groupId is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("groupId is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("groupId =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("groupId <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("groupId >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("groupId >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("groupId <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("groupId <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("groupId in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("groupId not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("groupId between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("groupId not between", value1, value2, "groupId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_company
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 26 19:51:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}