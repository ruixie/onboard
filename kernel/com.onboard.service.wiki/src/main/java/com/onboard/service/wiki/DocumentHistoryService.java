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
     * 根据主键获取文档历史对象
     * @param id
     * @return 按要求从数据库中获取出的DocumentHistory对象
     */
    DocumentHistory getDocumentHistoryById(int id);

    /**
     * 根据版本号获取某个文档的文档历史
     * @param documentId
     * @param version 该DocumentHistory的版本号
     * @return 按要求从数据库中获取出的DocumentHistory对象
     * @throws ResourceNotFoundException - 文档已经被删除
     * @throws ResourceNotFoundException - 版本号为version的文档历史不存在
     * @throws InternalServerErrorException - 存在多个版本号相同的文档历史
     */
    DocumentHistory getDocumentHistoryByVersion(int documentId, String version);

    /**
     * 按照创建时间从新到旧的顺序，获取某个文档的文档历史列表
     * 至少保证有一个初始元素在内 不包含content域 会根据document是否已经被删除 来抛出异常
     * @param documentId 
     * @param start 列表的起始位置
     * @param limit 列表的最大长度
     * @return 按要求从数据库中获取出的DocumentHistory列表
     */
    List<DocumentHistory> getDocumentHistoriesByDocumentId(int documentId, int start, int limit);

    /**
     * 在数据库中创建一个文档历史对象
     * @param documentHistory 需要被添加进数据库的文档历史对象
     * @return 返回创建的文档历史对象，包括数据库中的主键
     */
    DocumentHistory createDocumentHistory(DocumentHistory documentHistory);

    /**
     * 根据文档信息，在在数据库中创建一个文档历史对象
     * @param document 该文档历史所属的文档对象
     * @param note
     * @return 返回创建的文档历史对象，包括数据库中的主键
     */
    // TODO 此处的note不明作用，需要查明
    DocumentHistory createDocumentHistory(Document document, String note);

    /**
     * 对于传入的文档历史列表，对其按照创建日期从新到旧排序
     * @param list 需要进行排序的文档历史列表
     * @return 排序完成的文档历史列表
     */
    void sortDocumentHistoryByDate(List<DocumentHistory> list);
}
