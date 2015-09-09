package com.onboard.service.upload;

import java.util.List;

import com.onboard.domain.mapper.model.UploadExample;
import com.onboard.domain.model.Upload;
import com.onboard.service.base.BaseService;

/**
 * {@link Upload}服务接口
 * 
 * @author yewei
 * 
 */
public interface UploadService extends BaseService<Upload, UploadExample> {

    /**
     * 获取一个项目内的Upload
     * 
     * @param projectId
     * @param start
     * @param limit
     * @return
     */
    List<Upload> getUploadsByProject(int projectId, int start, int limit);

    /**
     * 移动Upload到新的项目下
     * 
     * @param upload
     * @param projectId
     */
    void moveUpload(Upload upload, int projectId);

}
