package com.onboard.service.index.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.onboard.domain.model.type.Indexable;

/**
 * 检索输出的结果文档
 * 
 * @author yewei
 * 
 */
public interface IndexDocument {
    
    public static final String ID_TEMLATE = "%s_%s";
    
    String getId();
    String getModelType();
    Integer getModelId();
    
    Integer getProjectId();
    String getProjectName();
    Integer getCompanyId();
    
    Date getCreatedTime();
    Integer getCreatorId();
    String getCreatorName();
    String getCreatorAvatar();
    List<Integer> getRelatorIds();
    
    String getTitle();
    void setTitle(String title);
    String getContent();
    void setContent(String content);
    String getAttachTitle();
    
    Indexable getIndexable();
    
    Map<String, Object> getExtendIndexFields();
    
    boolean needIndex();
    

}
