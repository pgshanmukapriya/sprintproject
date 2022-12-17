package com.abc.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.insurance.entity.LifeInsurance;



@Service
public interface LifeInsuranceService {
public LifeInsurance addLifeInsurance(LifeInsurance lifeInsurance)throws Exception;
public List<LifeInsurance> getAllLifeInsurance()throws Exception;
public LifeInsurance getLifeInsuranceBySumInsured(int sumInsured) throws Exception;
public LifeInsurance getLifeInsuranceByInsuranceName(String insuranceName)throws Exception;
public List<LifeInsurance> getLifeInsuranceByPremium(int premium) throws Exception;
public LifeInsurance updateLifeInsurance(LifeInsurance lifeInsurance)throws Exception;
public void delete(int hId)throws Exception;
public List<LifeInsurance> findLifeInsuranceWithSorting(String field)throws Exception;

public LifeInsurance getInsuranceById(int id);

public List<LifeInsurance> sortingBasedOnPremium()throws Exception;



}
