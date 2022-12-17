package com.abc.insurance.util;

import org.springframework.stereotype.Component;

import com.abc.insurance.dto.InsuranceReponseDTO;

import com.abc.insurance.entity.MedicalInsurance;
@Component
public class MedicalInsuranceDTOConvertor {

	

		public InsuranceReponseDTO convertToDTO(MedicalInsurance hi)
		{
			return new InsuranceReponseDTO(hi.getmId(), hi.getInsuranceName());
		}
	}

