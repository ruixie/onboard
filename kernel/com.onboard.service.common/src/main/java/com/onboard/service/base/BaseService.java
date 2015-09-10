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
package com.onboard.service.base;

import java.util.List;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.type.BaseOperateItem;

public interface BaseService<I extends BaseOperateItem, E extends BaseExample> {
    
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    I getById(int id);
    
    /**
     * TODO: delete this method
     * @param id
     * @return
     */
    I getByIdWithDetail(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<I> getAll();
    List<I> getAll(int start, int limit);

    /**
     * Get item list by sample
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<I> getBySample(I item);
    List<I> getBySample(I item, int start, int limit);

    /**
     * Get item count by sample
     * 
     * @param item
     * @return the count
     */
    int countBySample(I item);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<I> getByExample(E example);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(E example);

    /**
     * Create
     * 
     * @param item
     * @return the created Step
     */
    I create(I item);

    /**
     * update item except null value
     * 
     * @param item
     * @return the updated item
     */
    I updateSelective(I item);
    
    /**
     * update all
     * 
     * @param item
     * @return
     */
    I update(I item);

    /**
     * 
     * move to trash
     * 
     * @param id
     */
    void delete(int id);
    
    /**
     * move from trash
     * @param id
     */
    void recover(int id);
    
    /**
     * TODO: 重新整理名称
     * @param id
     */
    void deleteFromTrash(int id);
    
    /**
     * get model type
     * @return
     */
    String getModelType();
    
    /**
     * 新建item
     * @return
     */
    I newItem();
    
    /**
     * 新建example
     * @return
     */
    E newExample();
    
    /**
     * 根据item创建example
     * @param item
     * @return
     */
    E newExample(I item);
    
}
