package com.onboard.domain.model;

import com.onboard.domain.mapper.model.TrashObject;
import com.onboard.domain.model.type.BaseOperateItem;

/**
 * Domain model: Trash
 * 
 * @generated_by_elevenframework
 * 
 */
public class Trash extends TrashObject {

    BaseOperateItem identifiable;

    public Trash() {
        super();
    }

    public Trash(int id) {
        super(id);
    }

    public Trash(TrashObject obj) {
        super(obj);
    }

    public BaseOperateItem getIdentifiable() {
        return identifiable;
    }

    public void setIdentifiable(BaseOperateItem identifiable) {
        this.identifiable = identifiable;
    }

}
