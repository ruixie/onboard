package com.onboard.dto;

import java.util.UUID;

public class CompanyApplicationDTO implements DTO {

    private Integer id;
    private String teamName;
    private String contactEmail;
    private String contactName;
    private String teamSize;
    private String codeHost;
    private String description;
    private String code = UUID.randomUUID().toString();

    public CompanyApplicationDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getCodeHost() {
        return codeHost;
    }

    public void setCodeHost(String codeHost) {
        this.codeHost = codeHost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
