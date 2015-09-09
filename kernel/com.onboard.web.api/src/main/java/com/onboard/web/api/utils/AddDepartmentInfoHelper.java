package com.onboard.web.api.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.onboard.domain.model.Department;
import com.onboard.domain.model.User;
import com.onboard.service.account.DepartmentService;

/**
 * @author xuchen
 * 
 */
@Component
public class AddDepartmentInfoHelper {
    @Autowired
    DepartmentService departmentService;

    public void addDepartmentInfo(Model model, List<User> users, int companyId) {
        Department department = new Department();
        department.setCompanyId(companyId);
        model.addAttribute("groups",
                departmentService.getBySample(department, 0, -1));
        Map<Integer, Integer> userGroups = new HashMap<Integer, Integer>();
        for (User user : users) {
            Department d = departmentService.getDepartmentByCompanyIdByUserId(
                    companyId, user.getId());
            userGroups.put(user.getId(), d == null ? 0 : d.getId());
        }
        model.addAttribute("userGropus", userGroups);
    }
}
