package com.onboard.service.account;

import java.util.List;

import com.onboard.domain.mapper.model.DepartmentExample;
import com.onboard.domain.model.Department;
import com.onboard.domain.model.User;
import com.onboard.domain.model.UserCompany;
import com.onboard.service.base.BaseService;

/**
 * @author xuchen
 */
public interface DepartmentService extends BaseService<Department, DepartmentExample> {

    /**
     * 更新用户所在的组
     * 
     * @param userCompany
     */
    void updateDepartmentOfUser(UserCompany userCompany);

    /**
     * 对分组进行排序
     * 
     * @param ids
     */
    void sortDepartment(List<Integer> groupIds);

    /**
     * @param userId
     * @return
     */
    Department getDepartmentByCompanyIdByUserId(int companyId, int userId);

    /**
     * 找到用户在某公司的departmentId，并填充
     */
    void fillUserDepartmentInCompany(User user, int companyId);

    /**
     * 填充某公司一组用户的departmentId
     */
    void fillUsersDepartmentInCompany(List<User> users, int companyId);

}
