package com.abc.insurance.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.abc.insurance.Sort.SortingBasedOnPremiumHighToLow;
import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.repository.MedicalInsuranceRepository;



@Service
public class MedicalInsuranceServiceImpl implements MedicalInsuranceService {
	
	@Autowired
	MedicalInsuranceRepository medicalInsuranceRepository;
	
	@Override
	public void delete(int mId) throws Exception {
		medicalInsuranceRepository.deleteById(mId);
		
	}



	@Override
	@Transactional
	public MedicalInsurance addMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception {
		
		MedicalInsurance savedMedicalInsurance =  medicalInsuranceRepository.save(medicalInsurance);  // Note :  save() is already implemented by Spring Data JPA
		if(savedMedicalInsurance != null)
		{
			return savedMedicalInsurance;
		}
		else return null;
	}

	@Override
	public List<MedicalInsurance> getAllMedicalInsurance() throws Exception {

		List<MedicalInsurance> allInsurance = medicalInsuranceRepository.findAll(); // Note : same as save
		return allInsurance;
	}

	@Override
	public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured) throws Exception {
		return  medicalInsuranceRepository.getMedicalInsuranceBySumInsured(sumInsured);
	}

	@Override
	public List<MedicalInsurance> getMedicalInsuranceByPremium(int premium) throws Exception {
	
		return medicalInsuranceRepository.getMedicalInsuranceByPremium(premium);
	}

	@Override
	public MedicalInsurance updateMedicalInsurance(MedicalInsurance medicalInsurance) throws Exception{
		return medicalInsuranceRepository.save(medicalInsurance);
	}

	@Override
	public MedicalInsurance getMedicalInsuranceByInsuranceName(String insuranceName) throws Exception {
   MedicalInsurance outPut =  medicalInsuranceRepository.getMedicalInsuranceByInsuranceName(insuranceName);
		
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
	public MedicalInsurance getInsuranceBymId(int mId) {
		return medicalInsuranceRepository.getById(mId);
		
	}



	@Override
	public List<MedicalInsurance> findMedicalInsuranceWithSorting(String field) throws Exception {
		
		return medicalInsuranceRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	
	@Override
	public List<MedicalInsurance> sortingBasedOnPremium()throws Exception {
		List<MedicalInsurance> list=medicalInsuranceRepository.findAll();
		List<MedicalInsurance> medicalInsurances=new ArrayList<>();
		Collections.sort(list,new SortingBasedOnPremiumHighToLow());
		return list;
	}


}//end of class