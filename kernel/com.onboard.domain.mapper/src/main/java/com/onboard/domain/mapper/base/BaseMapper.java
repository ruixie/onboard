package com.onboard.domain.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.mapper.model.common.BaseItem;

public interface BaseMapper<R extends BaseItem, E extends BaseExample> {
    
    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(Integer id);

    int insert(R record);

    int insertSelective(R record);

    List<R> selectByExample(E example);

    R selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") R record, @Param("example") E example);

    int updateByExample(@Param("record") R record, @Param("example") E example);

    int updateByPrimaryKeySelective(R record);

    int updateByPrimaryKey(R record);

}
