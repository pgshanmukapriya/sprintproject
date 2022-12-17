package com.abc.insurance.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.LifeInsurance;

@Repository
public interface LifeInsuranceCustomRepository {
	public List<LifeInsurance> getLifeInsuranceByPremium(int premium)throws Exception;
	public LifeInsurance getLifeInsuranceBySumInsured(int sumInsured)throws Exception;
	public LifeInsurance getLifeInsuranceByInsuranceName(String insuranceName)throws Exception;
}

