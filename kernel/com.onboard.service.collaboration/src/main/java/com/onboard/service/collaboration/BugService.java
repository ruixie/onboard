package com.onboard.service.collaboration;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.onboard.domain.mapper.model.BugExample;
import com.onboard.domain.model.Bug;
import com.onboard.service.base.BaseService;

/**
 * {@link Bug} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface BugService extends BaseService<Bug, BugExample> {

    /**
     * 
     * @param projectId
     * @return
     */
    List<Bug> getAllBugsByProject(int projectId);

    /**
     * 
     * @param projectId
     * @return
     */
    List<Bug> getBugsByStatusByProject(int projectId, int status);

    /**
     * 
     * @param id
     * @return
     */
    Bug getBugByIdWithCommentAndSubscriable(int id);

    List<Bug> getOpenedBugsByProject(int projectId, int start, int limit);

    List<Bug> getFinishedBugsByProject(int projectId, int start, int limit);

    List<Bug> getCompletedBugsBetweenDates(Integer companyId, Date since, Date until);

    TreeMap<Date, Map<Integer, List<Bug>>> getCompletedBugsGroupByDateByUser(int companyId, int userId,
            List<Integer> projectList, Date until, int limit);

    TreeMap<Integer, List<Bug>> getOpenBugsByUser(Integer userId, List<Integer> projectList);

    /***
     * 日历中展示当前用户未完成的Bug
     * 
     * @param companyId
     * @param id
     * @param since
     * @param until
     * @return
     */
    List<Bug> getOpenBugsBetweenDatesByUser(int companyId, Integer userId, Date since, Date until);

    Long getCompletedBugAveDurationByProjectIdDateBackByMonth(Integer projectId, Integer months);

    Long getCompletedBugThirdQuarterDurationByProjectIdDateBackByMonth(Integer projectId, Integer months);
}
