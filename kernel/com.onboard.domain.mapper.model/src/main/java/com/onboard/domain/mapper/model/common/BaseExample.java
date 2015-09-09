package com.onboard.domain.mapper.model.common;

import java.util.List;

/**
 * XXXExample的公共接口
 * 
 * @author yewei
 *
 */
public interface BaseExample {

    String getOrderByClause();
    void setOrderByClause(String orderByClause);

    boolean isDistinct();
    void setDistinct(boolean distinct);

    int getStart();
    void setStart(int start);

    int getLimit();
    void setLimit(int limit);
    void setLimit(int start, int limit);

    List<BaseCriteria> getOredBaseCriteria();
    
    void clear();
    
}
