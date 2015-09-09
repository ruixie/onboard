package com.onboard.domain.transform;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Company;
import com.onboard.domain.model.Project;
import com.onboard.dto.CompanyDTO;

public class CompanyTransform {

    public static CompanyDTO companyAndProjectsToCompanyDTO(Company company, List<Project> projects) {
        CompanyDTO companyDTO = new CompanyDTO();
        BeanUtils.copyProperties(company, companyDTO);
        companyDTO.setProjects(ImmutableList.copyOf(Lists.transform(projects, ProjectTransform.PROJECT_DTO_FUNCTION)));
        return companyDTO;
    }

    public static CompanyDTO companyToCompanyDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        BeanUtils.copyProperties(company, companyDTO);
        return companyDTO;
    }

    public static Company companyDTOtoCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);
        return company;
    }
}
