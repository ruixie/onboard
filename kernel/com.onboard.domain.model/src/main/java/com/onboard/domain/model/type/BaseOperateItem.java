package com.onboard.domain.model.type;

import java.io.Serializable;
import java.util.Date;

import com.onboard.domain.mapper.model.common.BaseItem;

public interface BaseOperateItem extends BaseItem, Typeable, Serializable {
    
    Date getCreated();
    void setCreated(Date created);
    
    Date getUpdated();
    void setUpdated(Date updated);
    
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
    
    /**
     * 是否需要提供回收站功能
     * @return
     */
    boolean trashRequried();

}
