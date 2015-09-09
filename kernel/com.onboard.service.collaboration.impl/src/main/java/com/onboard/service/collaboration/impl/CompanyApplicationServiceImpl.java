package com.onboard.service.collaboration.impl;

import com.onboard.domain.mapper.CompanyApplicationMapper;
import com.onboard.domain.mapper.model.CompanyApplicationExample;
import com.onboard.domain.model.CompanyApplication;
import com.onboard.service.collaboration.CompanyApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link com.onboard.service.collaboration.CompanyApplicationService} Service implementation
 * 
 * @generated_by_elevenframework
 * 
 */
@Transactional
@Service("companyApplicationServiceBean")
public class CompanyApplicationServiceImpl implements CompanyApplicationService {

    public static final Logger logger = LoggerFactory.getLogger(CompanyApplicationServiceImpl.class);

    @Autowired
    private CompanyApplicationMapper companyApplicationMapper;

    @Override
    public CompanyApplication getCompanyApplicationById(int id) {
        return companyApplicationMapper.selectByPrimaryKey(id);
    }

    @Override
    public CompanyApplication getCompanyApplicationByToken(String token) {
        CompanyApplication sample = new CompanyApplication();
        sample.setCode(token);
        List<CompanyApplication> results = companyApplicationMapper.selectByExample(new CompanyApplicationExample(sample));

        if (results.isEmpty() || results.size() > 1) {
            return null;
        }

        return results.get(0);
    }

    @Override
    public List<CompanyApplication> getCompanyApplications(int start, int limit) {
        CompanyApplicationExample example = new CompanyApplicationExample(new CompanyApplication());
        example.setLimit(start, limit);
        return companyApplicationMapper.selectByExample(example);
    }

    @Override
    public CompanyApplication createCompanyApplication(CompanyApplication item) {
        companyApplicationMapper.insert(item);
        return item;
    }

    @Override
    public void deleteCompanyApplication(int id) {
        companyApplicationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void disableCompanyApplicationToken(int id) {
        CompanyApplication application = getCompanyApplicationById(id);
        if (application == null) {
            return;
        }
        application.setCode(null);
        companyApplicationMapper.updateByPrimaryKey(application);
    }

}
