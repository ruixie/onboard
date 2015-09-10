/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.collaboration;

import java.util.Date;
import java.util.List;

import com.onboard.domain.model.TodoDuration;

/**
 * {@link TodoDuration} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface TodoDurationService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    TodoDuration getTodoDurationById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<TodoDuration> getTodoDurations(int start, int limit);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<TodoDuration> getTodoDurationsByExample(TodoDuration item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(TodoDuration item);


    /**
     * Create
     * 
     * @param item
     * @return the created TodoDuration
     */
    TodoDuration createTodoDuration(TodoDuration item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    TodoDuration updateTodoDuration(TodoDuration item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteTodoDuration(int id);
    
    /**
     * 获取任务相关的工作时间
     * @param todoId
     * @return
     */
    List<TodoDuration> getDurationsByTodoId(Integer todoId);
    
    /**
     * 新建工作记录
     * @param companyId
     * @param projectId
     * @param todoId
     * @param start
     * @param end
     * @return
     */
    TodoDuration createDuration(Integer companyId, Integer projectId, Integer todoId, Integer userId, Date start, Date end);
    
    /**
     * 更新工作记录
     * @param id
     * @param start
     * @param end
     * @return
     */
    TodoDuration updateDuration(Integer id, Date start, Date end);
    
    List<TodoDuration> getUserDurationsInCompany(Integer userId, Integer companyId);
    
    List<TodoDuration> getUserDurationsInCompanyByStartTime(Integer userId, Integer companyId, Date startEarliestTime, Date startLatestTime);
}
