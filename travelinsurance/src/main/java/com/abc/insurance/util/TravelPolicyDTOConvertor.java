package com.abc.insurance.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.insurance.dto.DefaultResponseDTO;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;

@Component
public class TravelPolicyDTOConvertor {

	public static DefaultResponseDTO getTravelInsuranceDefaultResponseDTO(TravelPolicy travelPolicy) {
		DefaultResponseDTO dto = new DefaultResponseDTO(travelPolicy.getPolicyId(), travelPolicy.getClientName());

		return dto;

	}

}
