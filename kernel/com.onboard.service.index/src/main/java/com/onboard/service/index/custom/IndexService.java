package com.onboard.service.index.custom;

import java.util.List;

import com.onboard.domain.model.type.Indexable;
import com.onboard.service.index.model.Page;
import com.onboard.service.index.model.SearchQuery;
import com.onboard.service.index.model.SearchResult;

/**
 * 全文检索写入接口
 *
 * @author lvyiqiang, yewei
 *
 */
public interface IndexService {
    
    /**
     * 添加文档索引
     *
     * @param indexable
     *            被添加到全文索引的对象
     */
    public void addIndex(Indexable indexable);

    /**
     * 更新文档索引
     *
     * @param modifiedIndexable
     *            新的对象，用于更新全文索引中的旧文档
     */
    public void updateIndex(Indexable modifiedIndexable);

    /**
     * 根据文档Id删除全文索引中的单个文档
     *
     * @param id
     *            文档Id
     */
    public void deleteIndexById(String id);

    /**
     * 根据文档Id列表删除全文索引中相应的文档
     *
     * @param idList
     *            文档Id列表
     */
    public void deleteIndexByIdList(List<String> idList);

    /**
     * 根据关键词，项目列表和分页信息对特定的对象进行查询
     * 
     * @param key
     * @param projectIdList
     * @param page
     * @param modelType
     * @return {@link SearchResult}对象
     */
    public SearchResult search(String key, SearchQuery searchQuery, Page page);
    

    /**
     * 关键词推荐
     * 
     * @param key
     * @return 相关的关键词列表
     */
    public List<String> suggest(String key);
}
