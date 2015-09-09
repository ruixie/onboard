package com.onboard.domain.transform;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.onboard.domain.model.Department;
import com.onboard.domain.model.User;
import com.onboard.dto.DepartmentDTO;

public class DepartmentTransform {
    public static DepartmentDTO departmentAndUsersToDepartmentDTO(Department department, List<User> users) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);
        departmentDTO.setUsers(Lists.transform(users, UserTransform.USER_TO_USERDTO_FUNCTION));
        return departmentDTO;
    }

}
