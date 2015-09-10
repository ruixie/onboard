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
package com.onboard.service.wiki;

import java.util.Date;
import java.util.List;

import com.onboard.domain.mapper.model.DocumentExample;
import com.onboard.domain.model.Document;
import com.onboard.service.base.BaseService;

/**
 * {@link Document}服务接口
 * 
 * @author yewei, completed by gourui
 * 
 */
public interface DocumentService extends BaseService<Document, DocumentExample> {

    public static final int UNLOCK_NOT_LOCKED = -1;
    public static final int UNLOCK_CANT_UNLOCK = 0;
    public static final int LOCK_CANT_LOCK = -2;

    /**
     * 按照更新时间从新到老的顺序，获取一个项目内的Document列表
     * @param projectId 项目Id
     * @param start 列表的起始位置
     * @param limit 列表的最大长度
     * @return 按要求从数据库中获取出的Document列表
     */
    List<Document> getDocumentsByProject(int projectId, int start, int limit);

    /**
     * 按照更新时间从新到老的顺序，获取一个项目内的Document列表，至多n个，且附带详细信息
     * @param projectId 项目Id
     * @param n 获取文档的上限数目
     * @return 按要求从数据库中获取出的Document列表
     */
    List<Document> getNUptodateDocuments(int projectId, int n);

    /***
     * 获取一个项目内所有创建日期在指定范围内的文档
     * @author Chenlong
     * @param companyId 项目Id
     * @param since 最早可行的创建时间（包含）
     * @param until 最晚可行的创建时间（不包含）
     * @return 按要求从数据库中获取出的Document列表
     */
    List<Document> getDocumentsByCompanyIdBetweenDates(int companyId, Date since, Date until);
}
