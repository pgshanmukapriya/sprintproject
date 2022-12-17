package com.abc.insurance.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;



@Service
public interface MedicalInsuranceService {
public MedicalInsurance addMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception;
public List<MedicalInsurance> getAllMedicalInsurance()throws Exception;
public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured) throws Exception;
public MedicalInsurance getMedicalInsuranceByInsuranceName(String insuranceName)throws Exception;
public List<MedicalInsurance> getMedicalInsuranceByPremium(int premium) throws Exception;
public MedicalInsurance updateMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception;
public List<MedicalInsurance> findMedicalInsuranceWithSorting(String field)throws Exception;
public List<MedicalInsurance> sortingBasedOnPremium()throws Exception;
public void delete(int mId)throws Exception;
public MedicalInsurance getInsuranceBymId(int mId);





}