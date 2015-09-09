package com.onboard.domain.model;

import java.io.Serializable;

import com.onboard.domain.mapper.model.CollectionObject;

/**
 * Domain model: Collection
 * 
 * @generated_by_elevenframework
 * 
 */
public class Collection extends CollectionObject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Collection() {
        super();
    }

    public Collection(int id) {
        super(id);
    }

    public Collection(boolean deleted) {
        super(deleted);
    }

    public Collection(int id, boolean deleted) {
        super(id, deleted);
    }

    public Collection(CollectionObject obj) {
        super(obj);
    }

}
