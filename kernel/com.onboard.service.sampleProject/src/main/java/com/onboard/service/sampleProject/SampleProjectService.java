package com.onboard.service.sampleProject;

import com.onboard.domain.model.User;

/**
 * 创建示例项目服务
 * 
 * @author xingliang
 * 
 */
public interface SampleProjectService {

    /**
     * 建立示例项目
     * 
     * @param companyId
     */
    void createSampleProjectByCompanyId(Integer companyId, User creator);
}
