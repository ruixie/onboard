package com.onboard.domain.model;

import com.onboard.domain.mapper.model.KeywordObject;

/**
 * Domain model: Keyword
 * 
 * @generated_by_elevenframework
 * 
 */
public class Keyword extends KeywordObject {

    public Keyword() {
        super();
    }

    public Keyword(int id) {
        super(id);
    }

    public Keyword(KeywordObject obj) {
        super(obj);
    }

    public Keyword(boolean deleted) {
        super();
        setDeleted(deleted);
    }

    public Keyword(int id, boolean deleted) {
        super(id);
        setDeleted(deleted);
    }

    public void addTimes(int add) {
        setTimes(getTimes() + add);
    }

    public void minusTimes(int minus) {
        setTimes(getTimes() - minus);
    }
}
