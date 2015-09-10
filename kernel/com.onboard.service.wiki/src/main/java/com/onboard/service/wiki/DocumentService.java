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
     * 获取一个项目内的Document
     * 
     * @param projectId
     * @param start
     * @param limit
     * @return
     */
    List<Document> getDocumentsByProject(int projectId, int lastId, int limit);

    /**
     * 获取带正文的n个最新的文档历史
     * 
     * @param projectId
     * @return
     */
    List<Document> getNUptodateDocuments(int projectId, int n);

    /***
     * @author Chenlong
     * @param companyId
     * @param since
     * @param until
     * @return
     */
    List<Document> getDocumentsByCompanyIdBetweenDates(int companyId, Date since, Date until);
}
