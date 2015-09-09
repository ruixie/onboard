package com.onboard.service.index.custom;

import java.util.List;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.domain.model.type.Indexable;
import com.onboard.service.index.model.IndexDocument;

/**
 * 索引对象需要暴露的服务，例如“讨论”对象需要被引用，则需要针对该对象提供该接口的实现
 * 
 * @author yewei
 * 
 */
public interface IndexableService extends IdentifiableOperator {
    

    /**
     * TODO: replace it with the mapper
     * 根据对象示例选择对象，通常调用mapper的selectByExample方法即可
     * 
     * @param baseExample
     * @return
     */
    List<Indexable> getIndexablesByExample(BaseExample baseExample);
    
    /**
     * 将indexable变为索引
     * @param indexable
     * @return
     */
    IndexDocument indexableToIndexDocument(Indexable indexable);
    

}
