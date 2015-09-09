package com.onboard.domain.model.type;

import java.util.Date;
import java.util.List;

/**
 * 可进入迭代的对象
 * @author xr
 *
 */
public interface Iterable extends BaseProjectItem {
    
    /**
     * 是否被完成
     * @return
     */
    Boolean getCompleted();
    
    /**
     * 设置任务是否被完成
     * @param completed
     */
    void setCompleted(Boolean completed);
    
    /**
     * 完成时间
     * @return
     */
    Date getCompletedTime();
    
    /**
     * 完成时间
     * @return
     */
    void setCompletedTime(Date completedTime);
    
    /**
     * 在本次迭代是否被完成
     * @return
     */
    Boolean getIterationCompleted();
    
    /**
     * 设置任务在本次迭代是否被完成，由迭代相关逻辑进行处理
     * @param completed
     */
    void setIterationCompleted(Boolean completed);
    
    /**
     * 如果本次迭代已经完成，本次迭代的完成时间
     * @return
     */
    Date getIterationCompletedTime();
    
    /**
     * 设置本次迭代的完成时间
     * @return
     */
    void setIterationCompletedTime(Date completedTime);
    
    
    
    /**
     * 获取进入看板的对象
     * @return
     */
    List<Boardable> getBoardables();

}
