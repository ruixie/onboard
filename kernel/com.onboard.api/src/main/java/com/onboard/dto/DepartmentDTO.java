package com.onboard.dto;

import java.util.List;

public class DepartmentDTO implements DTO {

    private Integer id;
    private String name;
    private Integer companyId;
    private Integer customOrder;
    private List<UserDTO> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(Integer customOrder) {
        this.customOrder = customOrder;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
