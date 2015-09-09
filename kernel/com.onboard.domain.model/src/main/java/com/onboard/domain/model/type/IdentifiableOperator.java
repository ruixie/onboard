package com.onboard.domain.model.type;

/**
 * 操作{@link BaseProjectItem}的对象
 * 
 * @author yewei
 * 
 */
public interface IdentifiableOperator {

    /**
     * 如果特定的{@link IdentifiableOperator}实现针对的是所有类型的对象，则让modelType方法返回NONE_TYPE即可
     */
    String NONE_TYPE = "none_type";

    /**
     * 所操作的{@link BaseProjectItem}的类型
     * 
     * @return
     */
    String modelType();

}
