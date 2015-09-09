package com.onboard.service.index.model;

import java.util.List;
import java.util.Map;

public class SearchQuery {
    
    private List<String> modelTypes;
    private List<Integer> projectIds;
    private List<Integer> companyIds;
    private List<Integer> creatorIds;
    private List<Integer> relatorIds;
    private Map<String, List<Object>> queryStrings;
    
    public List<String> getModelTypes() {
        return modelTypes;
    }
    public void setModelTypes(List<String> modelTypes) {
        this.modelTypes = modelTypes;
    }
    public List<Integer> getProjectIds() {
        return projectIds;
    }
    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }
    public List<Integer> getCompanyIds() {
        return companyIds;
    }
    public void setCompanyIds(List<Integer> companyIds) {
        this.companyIds = companyIds;
    }
    public List<Integer> getCreatorIds() {
        return creatorIds;
    }
    public void setCreatorIds(List<Integer> creatorIds) {
        this.creatorIds = creatorIds;
    }
    public List<Integer> getRelatorIds() {
        return relatorIds;
    }
    public void setRelatorIds(List<Integer> relatorIds) {
        this.relatorIds = relatorIds;
    }
    public Map<String, List<Object>> getQueryStrings() {
        return queryStrings;
    }
    public void setQueryStrings(Map<String, List<Object>> queryStrings) {
        this.queryStrings = queryStrings;
    }

}
