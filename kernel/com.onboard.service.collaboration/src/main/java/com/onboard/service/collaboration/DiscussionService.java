package com.onboard.service.collaboration;

import java.util.Date;
import java.util.List;

import com.onboard.domain.mapper.model.DiscussionExample;
import com.onboard.domain.model.Discussion;
import com.onboard.service.base.BaseService;

/**
 * {@link Discussion}服务接口
 * 
 * @author huangsz, yewei
 */
public interface DiscussionService extends BaseService<Discussion, DiscussionExample> {

    /**
     * TODO: 重新整理之
     * 为更新Discussion获取，不需要填充comment 只需要attachments和subscriber
     * 
     * @param id
     * @return
     */
    Discussion getDiscussionByIdForUpdate(int id);

    /**
     * 获取某个project的所有Discussion
     * 
     * @param projectId
     * @return
     */
    List<Discussion> getDiscussionsByProjectId(int projectId);

    /**
     * 移动Discussion到新的项目下
     * 
     * @param discussion
     * @param projectId
     */
    void moveDiscussion(Discussion discussion, int projectId);

    /**
     * 获取回收站中的discussion
     * 
     * @return
     */
    List<Discussion> getDiscardedDiscussions();

    /***
     * @author Chenlong
     * @param companyId
     * @param since
     * @param until
     * @return
     */
    List<Discussion> getDiscussionsByCompanyIdBetweenDates(int companyId, Date since, Date until);
}
