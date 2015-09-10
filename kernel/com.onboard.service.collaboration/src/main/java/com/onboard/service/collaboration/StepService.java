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
import java.util.Map;
import java.util.TreeMap;

import com.onboard.domain.mapper.model.StepExample;
import com.onboard.domain.model.Step;
import com.onboard.service.base.BaseService;

/**
 * {@link Step} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface StepService extends BaseService<Step, StepExample> {

    /**
     * 根据attach获取steps
     * 
     * @param modelType
     * @param modelId
     * @return
     */
    List<Step> getByAttachTypeAndId(String attachType, Integer attachId);

    /***
     * 统计已完成的Step
     * 
     * @param companyId
     * @param since
     * @param until
     * @return
     */
    List<Step> getCompletedStepsBetweenDates(Integer companyId, Date since, Date until);

    /***
     * 日历中展示当前用户未完成的S
     * 
     * @param companyId
     * @param id
     * @param since
     * @param until
     * @return
     */
    List<Step> getOpenStepsBetweenDatesByUser(int companyId, Integer userId, Date since, Date until);

    TreeMap<Date, Map<Integer, List<Step>>> getCompletedStepsGroupByDateByUser(int companyId, int userId,
            List<Integer> projectList, Date until, int limit);

    Map<Integer, List<Step>> getOpenStepsByUser(Integer userId, List<Integer> projectList);
}
