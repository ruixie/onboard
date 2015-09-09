package com.onboard.domain.mapper.model.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis Generator生成的Example类的内部类GeneratedCriteria的公共部分， 特定于Date和Time的公共方法不在该类中，
 * 特定于表字段名的方法在BaseCriteria的子类中
 * 
 * @author yewei
 * 
 */
public class BaseCriteria {
    
    protected List<Criterion> criteria;

    protected BaseCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }
}
