package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.CompanyApplication;
import com.onboard.dto.CompanyApplicationDTO;

public class CompanyApplicationTransform {

    public static final Function<CompanyApplication, CompanyApplicationDTO> TO_DTO_FUNCTION = new Function<CompanyApplication, CompanyApplicationDTO>() {
        @Override
        public CompanyApplicationDTO apply(CompanyApplication input) {
            return companyApplicationToCompanyApplicationDTO(input);
        }
    };

    public static CompanyApplicationDTO companyApplicationToCompanyApplicationDTO(CompanyApplication companyApplication) {
        CompanyApplicationDTO companyApplicationDTO = new CompanyApplicationDTO();
        BeanUtils.copyProperties(companyApplication, companyApplicationDTO);
        return companyApplicationDTO;
    }

    public static CompanyApplication companyApplicationDTOtoCompanyApplication(
            CompanyApplicationDTO companyApplicationDTO) {
        CompanyApplication companyApplication = new CompanyApplication();
        BeanUtils.copyProperties(companyApplicationDTO, companyApplication);
        return companyApplication;
    }

}
