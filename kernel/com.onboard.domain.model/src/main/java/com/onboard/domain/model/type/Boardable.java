package com.onboard.domain.model.type;

import com.onboard.domain.model.User;

/**
 * 可以进看板的对象
 * 
 * @author xr
 * 
 */
public interface Boardable {

    /**
     * 在看板内的状态
     * 
     * @return
     */
    String getIterationStatus();

    /**
     * 责任人
     * 
     * @return
     */
    User getAssignee();

    /**
     * 设置责任人
     * 
     * @param user
     */
    void setAssignee(User user);

}
