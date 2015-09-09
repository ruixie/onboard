package com.onboard.service.index.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.onboard.domain.model.type.Indexable;

public class IndexDocumentBuilder {
    
    private final IndexDocumentImpl indexDocument = new IndexDocumentImpl();
    
    public static String getId(String modelType, Integer modelId){
        return String.format(IndexDocument.ID_TEMLATE, modelType, modelId);
    }

    public static String getId(IndexDocument indexDocument){
        return getId(indexDocument.getModelType(), indexDocument.getModelId());
    }
    public static String getId(Indexable indexable){
        return getId(indexable.getType(), indexable.getId());
    }
    
    public static IndexDocumentBuilder getBuilder(){
        return new IndexDocumentBuilder();
    }
    
    public IndexDocumentBuilder indexable(Indexable indexable){
        indexDocument.setCompanyId(indexable.getCompanyId());
//        indexDocument.setCreatedTime(indexable.getCreated());
        indexDocument.setCreatedTime(new Date());
        //TODO: add creator avatar in indentifiable
//        indexDocument.setCreatorAvatar(indexable.getCreatorAvatar());
        indexDocument.setCreatorAvatar("test");
        indexDocument.setCreatorId(indexable.getCreatorId());
        indexDocument.setCreatorName(indexable.getCreatorName());
        indexDocument.setId(getId(indexable));
        indexDocument.setIndexable(indexable);
        indexDocument.setModelId(indexable.getId());
        indexDocument.setModelType(indexable.getType());
        indexDocument.setProjectId(indexable.getProjectId());
//        indexDocument.setProjectName(indexable.getProjectName());
        indexDocument.setProjectName("onboard");
        return this;
    }
    
    public IndexDocumentBuilder content(String content){
        indexDocument.setContent(content);
        return this;
    }
    
    public IndexDocumentBuilder relatorIds(List<Integer> relatorIds){
        indexDocument.setRelatorIds(relatorIds);
        return this;
    }
    
    public IndexDocumentBuilder title(String title){
        indexDocument.setTitle(title);
        return this;
    }
    
    public IndexDocumentBuilder attachTtitle(String title){
        indexDocument.setAttachTitle(title);
        return this;
    }
    
    public IndexDocumentBuilder extendIndexFields(Map<String, Object> fields){
        indexDocument.setExtendIndexFileds(fields);
        return this;
    }
    
    public IndexDocument build(){
       indexDocument.setId(IndexDocumentBuilder.getId(indexDocument));
       return indexDocument;
    }

}
