package com.onboard.service.collaboration;

import java.util.List;

import com.onboard.domain.mapper.model.KeywordExample;
import com.onboard.domain.model.Keyword;
import com.onboard.domain.model.type.Recommendable;

/**
 * {@link Keyword} Service Interface
 * 
 * @author XingLiang
 * 
 */
public interface KeywordService {

    final static Integer PER_IDENTIFIABLE_KEYWORD_COUNT = 5;

    /**
     * 获取用户的关键词，按times排序
     * 
     * @param UserId
     * @return
     */
    public List<Keyword> getKeywordsByUser(int userId, int start, int limit);

    /**
     * 获取用户在一个公司中的关键词，按times排序
     * 
     * @param UserId
     * @return
     */
    public List<Keyword> getKeywordsByUserByCompany(int companyId, int userId, int start, int limit);

    /**
     * 根据identifiable生成或更新关键词
     * 
     * @param identifiable
     */
    public void generateOrUpdateKeywordsByIdentifiable(Recommendable identifiable);

    /**
     * 根据identifiable的删除更新关键词
     * 
     * @param identifiable
     */
    public void deleteKeywordsByIdentifiable(Recommendable identifiable);

    public void addKeywordToUser(Recommendable identifiable, int userId);

    /**
     * 根据文本提取关键词
     * 
     * @param text
     * @return
     */
    public List<String> getKeywordsByText(String text);

    public void deleteKeywordByExample(KeywordExample keywordExample);

    /**
     * 重新生成tfidf
     * 
     */
    public void regenerateKeywordTfidf();

}
