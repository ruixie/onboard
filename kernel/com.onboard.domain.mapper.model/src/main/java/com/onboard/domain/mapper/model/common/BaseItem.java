package com.onboard.domain.mapper.model.common;

public interface BaseItem {
    
    Integer getId();
    void setId(Integer id);

    BaseItem copy();

}
