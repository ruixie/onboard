package com.onboard.service.index;

import org.aspectj.lang.ProceedingJoinPoint;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.type.Indexable;

/**
 * 更新索引的切面
 * 
 * @author yewei
 *
 */
public interface IndexAspect {
    /**
     * 使用切面添加文档
     * 
     * @param item
     *            文档
     */
    public void insert(Indexable item);

    /**
     * 使用切面添加文档
     * 
     * @param item
     *            文档
     */
    public void insertSelective(Indexable item);

    /**
     * 使用切面更新文档
     * 
     * @param item
     *            文档
     */
    public void updateByPrimaryKey(Indexable item);

    /**
     * 使用切面更新文档
     * 
     * @param item
     *            文档
     */
    public void updateByPrimaryKeySelective(Indexable item);

    /**
     * 使用切面更新文档
     * 
     * @param item
     *            文档
     */
    public void updateByExample(Indexable item, BaseExample itemExample);

    /**
     * 使用切面更新文档
     * 
     * @param item
     *            文档
     */
    public void updateByExampleSelective(Indexable item, BaseExample itemExample);

    /**
     * 使用切面删除文档
     * 
     * @param item
     *            文档
     */
    public Object deleteByPrimaryKey(ProceedingJoinPoint joinpoint);

    /**
     * 使用切面删除文档
     * 
     * @param item
     *            文档
     */
    public Object deleteByExample(ProceedingJoinPoint joinpoint);

}
