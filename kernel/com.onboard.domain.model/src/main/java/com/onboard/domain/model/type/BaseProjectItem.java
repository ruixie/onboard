package com.onboard.domain.model.type;


/**
 * 具有id和类型的对象
 * 
 * @author yewei
 * 
 */
public interface BaseProjectItem extends Typeable, BaseCompanyItem {

    Integer getProjectId();
    void setProjectId(Integer projectId);
    
//    String getProjectName();
//    void setProjectName(String projectName);
}
