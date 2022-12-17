package com.abc.insurance.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.entity.MedicalPolicies;

@Component
@Scope("singleton")
public class MedicalPoliciesDTOConvertor {

	public static DefaultResponseDTO  getMedicalPoliciesDefaultDTO(MedicalPolicies medicalPolicies)
	{
		DefaultResponseDTO dto = new DefaultResponseDTO(
				medicalPolicies.getClientName(), 
				medicalPolicies.getMedicalPolicyId(), 
				medicalPolicies.getMedicalInsurance().getInsuranceName(),
				                 "User Policies Created , policy Id : "+medicalPolicies.getMedicalInsurance().getmId());
		
		return dto;
	}
}
