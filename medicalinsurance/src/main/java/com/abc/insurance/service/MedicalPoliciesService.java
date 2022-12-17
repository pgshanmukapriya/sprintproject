package com.abc.insurance.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
@Service
public interface MedicalPoliciesService {
	public MedicalPolicies addMedicalPolicies(MedicalPolicies medicalPolicies)throws Exception;
	public List<MedicalPolicies> viewAllPolicies()throws Exception;
	public List<MedicalPolicies> getMedicalPoliciesBetweenPolicyNumber(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	public MedicalPolicies linkMedicalInsurance(MedicalInsurance medicalInsurance,MedicalPolicies  medicalPolicies);
	public MedicalPolicies updateMedicalPolicies(MedicalPolicies medicalPolicies)throws Exception;
	public List<MedicalPolicies> findMedicalPoliciesWithSorting(String field)throws Exception;
	public MedicalPolicies getMedicalPoliciesByClientName(String clientName)throws Exception;
	public void delete(int medicalPolicyId) throws Exception;

}