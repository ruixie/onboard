package com.onboard.domain.model;

import com.onboard.domain.mapper.model.IterationAttachObject;
import com.onboard.domain.model.type.Iterable;

/**
 * Domain model: IterationAttach
 * 
 * @generated_by_elevenframework
 * 
 */
public class IterationAttach extends IterationAttachObject {
    
    private Iterable iterable;
    
    public Iterable getIterable() {
        return iterable;
    }

    public void setIterable(Iterable iterable) {
        this.iterable = iterable;
        this.setObjectId(iterable.getId());
        this.setObjectType(iterable.getType());
    }

    public IterationAttach() {
        super();
    }

    public IterationAttach(int id) {
        super(id);
    }

    public IterationAttach(IterationAttachObject obj) {
        super(obj);
    }

}
