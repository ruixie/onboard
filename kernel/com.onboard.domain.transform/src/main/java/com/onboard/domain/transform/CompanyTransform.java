/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
