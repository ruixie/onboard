package com.onboard.service.collaboration;

import java.util.List;

import com.onboard.domain.mapper.model.StoryExample;
import com.onboard.domain.model.Story;
import com.onboard.service.base.BaseService;

/**
 * TODO
 * @author xr
 *
 */
public interface StoryService extends BaseService<Story, StoryExample> {

    String ALL_STORY = "all-story";
    String COMPLETED_STORY = "completed-story";
    String UNCOMPLETED_STORY = "uncompleted-story";

    /**
     * 根据id获取需求，不填充需求树
     * 
     * @param storyId
     * @return
     */
    Story getStoryByIdWithoutChilds(int storyId);

    /**
     * 根据父节点id获取所有未完成的需求，并填充每个子需求的需求树
     * 
     * @param projectId
     * @param parentStoryId
     * @return
     */
    List<Story> getUnCompletedStoriesByParentId(int projectId, int parentStoryId);

    /**
     * 获取项目所有需求
     * 
     * @param projectId
     * @return
     */
    List<Story> getAllStoriesByProjectId(int projectId, int parentStoryId);

    /**
     * 根据父节点id获取所有完成的需求，并填充每个子需求的需求树
     * 
     * @param projectId
     * @param parentStoryId
     * @return
     */
    List<Story> getCompletedStoriesByParentId(int projectId, int parentStoryId);

    /**
     * 获取一个项目所有已完成需求
     * 
     * @param projectId
     * @return
     */
    List<Story> getAllCompletedStoriesByProjectId(int projectId);

    /**
     * 根据创建者id获取所有需求，不填充需求树
     * 
     * @param projectId
     * @param parentStoryId
     * @return
     */
    List<Story> getStoriesByCreatorId(int creatorId);

    Integer getCompletedStoryCount(int parentStoryId);

    Integer getUncompletedStoryCount(int parentStoryId);

    /**
     * 更新需求，但是并不更新需求的父节点
     * 
     * @param story
     * @return
     */
    Story updateStoryWithoutChangingParent(Story story);

    /**
     * 将storyId对应的需求的父节点id改为targetParentId, 并避免出现环, 如果此需求未完成，目标父需求已完成则重新打开父需求
     * 
     * @param storyId
     * @param targetParentId
     * @return 是否移动成功
     */
    Boolean changeStoryParentStoryId(int storyId, int targetParentId);

    /**
     * 开启需求，并打开所有祖先需求
     * 
     * @param storyId
     */
    void updateAndOpenStory(int storyId);

    /**
     * 完成需求，并更新父需求可完成状态。
     * 
     * @param storyId
     */
    void updateAndCompleteStory(int storyId);

    List<Story> getUnCompletedStoriesByProjectIdOrderByPosition(int projectId, int start, int limit);

    List<Story> getCompletedStoriesByProjectIdOrderByPosition(int projectId, int start, int limit);

    int getChildCountByParentId(int parentId);
}
