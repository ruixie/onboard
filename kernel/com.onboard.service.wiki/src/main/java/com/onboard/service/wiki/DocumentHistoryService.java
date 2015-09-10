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

import java.util.List;

import com.onboard.domain.model.Document;
import com.onboard.domain.model.DocumentHistory;

/**
 * {@link DocumentHistory}服务接口
 * 
 * @author gourui
 * 
 */
public interface DocumentHistoryService {

    /**
     * 根据id获取DocumentHistory对象
     * 
     * @param id
     *            DocumentHistory id
     * @return
     */
    DocumentHistory getDocumentHistoryById(int id);

    /**
     * 根据版本号version获取DocumentHistory对象 会根据document是否已经被删除 or version不存在 来抛出异常
     * 
     * @param id
     *            DocumentHistory id
     * @return
     */
    DocumentHistory getDocumentHistoryByVersion(int documentId, String version);

    /**
     * 获取一个项目内的所有DocumentHistory,并且按时间倒序排好序,至少保证有一个初始元素在内 不包含content域 会根据document是否已经被删除 来抛出异常
     * 
     * @param projectId
     * @param start
     * @param limit
     * @return
     */
    List<DocumentHistory> getDocumentHistoriesByDocumentId(int documentId, int start, int limit);

    /**
     * 创建一个DocumentHistory对象
     * 
     * @param document
     * @return 返回创建的DocumentHistory对象，包括数据库中的id
     */
    DocumentHistory createDocumentHistory(DocumentHistory documentHistory);

    /**
     * 用document来创建一个DocumentHistory对象（在新建和编辑文档的时候被调用）
     * 
     * @param document
     * @return 返回创建的DocumentHistory对象，包括数据库中的id
     */
    DocumentHistory createDocumentHistory(Document document, String note);

    /**
     * 将list中的DocumentHistory以时间倒序排序
     * 
     * @param list
     * @return
     */
    void sortDocumentHistoryByDate(List<DocumentHistory> list);
}
