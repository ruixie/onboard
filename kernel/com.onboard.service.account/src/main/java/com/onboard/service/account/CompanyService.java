package com.onboard.service.account;

import java.util.List;

import com.onboard.domain.mapper.model.CompanyExample;
import com.onboard.domain.model.Company;
import com.onboard.service.base.BaseService;

/**
 * {@link Company}相关服务
 * 
 * @author huangsz
 * 
 */
public interface CompanyService extends BaseService<Company, CompanyExample> {
    /**
     * 获取某个用户所在的company列表
     * 
     * @param userId
     * @return
     */
    List<Company> getCompaniesByUserId(int userId);

    /**
     * 在company中移除用户
     * 
     * @param companyId
     * @param userId
     */
    void removeUser(Integer companyId, Integer userId);

    /**
     * 是否包含用户
     * 
     * @param companyId
     * @param userId
     * @return
     */
    boolean containsUser(Integer companyId, Integer userId);

}
