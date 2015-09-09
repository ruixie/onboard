package com.onboard.service.collaboration;

import com.onboard.domain.model.CompanyApplication;

import java.util.List;

/**
 * {@link CompanyApplication} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface CompanyApplicationService {

    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    CompanyApplication getCompanyApplicationById(int id);


    CompanyApplication getCompanyApplicationByToken(String token);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<CompanyApplication> getCompanyApplications(int start, int limit);

    /**
     * Create
     * 
     * @param item
     * @return the created CompanyApplication
     */
    CompanyApplication createCompanyApplication(CompanyApplication item);

    void deleteCompanyApplication(int id);

    void disableCompanyApplicationToken(int id);
}
