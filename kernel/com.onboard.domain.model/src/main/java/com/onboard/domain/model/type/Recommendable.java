package com.onboard.domain.model.type;

/**
 * 可以生成关键词的类型
 * 
 * @author XingLiang
 * 
 */
public interface Recommendable extends BaseProjectItem {
    /**
     * 关键词生成用的文本
     * 
     * @return
     */
    String generateText();
}
