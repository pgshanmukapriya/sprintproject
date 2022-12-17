package com.abc.insurance.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.repository.MedicalPoliciesRepository;




@Service
public class MedicalPoliciesServiceImpl implements MedicalPoliciesService {
	@Autowired
	MedicalPoliciesRepository medicalPoliciesRepository;
	
	@Override
	@Transactional
	public MedicalPolicies addMedicalPolicies(MedicalPolicies medicalPolicies) throws Exception {
		MedicalPolicies savedMedicalPolicy =medicalPoliciesRepository.save(medicalPolicies);
		return  savedMedicalPolicy;
	}

	@Override
	public List<MedicalPolicies> viewAllPolicies() throws Exception {
		List<MedicalPolicies> allPolicies = medicalPoliciesRepository.findAll(); // Note : same as save
		return allPolicies;
	}

	@Override
	public List<MedicalPolicies> getMedicalPoliciesBetweenPolicyNumber(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return  medicalPoliciesRepository.getMedicalPoliciesBetweenPolicyNumber(range1, range2);
	}

	@Override
	public MedicalPolicies getMedicalPoliciesByClientName(String clientName) throws Exception {
		 MedicalPolicies outPut =  medicalPoliciesRepository.getMedicalPoliciesByClientName(clientName);
			
			if(outPut == null)
			{
				throw new EntityNotFoundException(outPut+" not listed in the database");
			}
			else
			{
				return outPut;
			}
	}

	
	@Override
	@Transactional
	public MedicalPolicies linkMedicalInsurance(MedicalInsurance medicalInsurance, MedicalPolicies medicalPolicies) {
		medicalPolicies.setMedicalInsurance(medicalInsurance);
		return medicalPolicies;
	}

	@Override
	public MedicalPolicies updateMedicalPolicies(MedicalPolicies medicalPolicies) throws Exception {
		return medicalPoliciesRepository.save(medicalPolicies);
	}
	@Override
	public List<MedicalPolicies> findMedicalPoliciesWithSorting(String field) throws Exception {
		return medicalPoliciesRepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	@Override
	@Transactional
	public void delete(int medicalPolicyId)throws Exception {
		medicalPoliciesRepository.deleteById(medicalPolicyId);
	}

	

	

}