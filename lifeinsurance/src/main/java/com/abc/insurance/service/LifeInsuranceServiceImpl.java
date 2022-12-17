package com.abc.insurance.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.LifeInsurance;
import com.abc.insurance.repository.LifeInsuranceRepository;

import org.springframework.data.domain.Sort;
import com.abc.insurance.sort.SortingBasedOnPremiumHighToLow;

@Service
public class LifeInsuranceServiceImpl implements LifeInsuranceService {
	@Autowired
	LifeInsuranceRepository lifeInsuranceRepository;

	
	
	
	@Override
	public LifeInsurance getInsuranceById(int id) {
		return lifeInsuranceRepository.getReferenceById(id);
	}

	@Override

	public LifeInsurance addLifeInsurance(LifeInsurance lifeInsurance)throws Exception {
		
		LifeInsurance savedLifeInsurance =  lifeInsuranceRepository.save(lifeInsurance);  // Note :  save() is already implemented by Spring Data JPA
		if(savedLifeInsurance != null)
		{
			return savedLifeInsurance;
		}
		else return null;
	}

	@Override
	public List<LifeInsurance> getAllLifeInsurance() throws Exception {

		List<LifeInsurance> allInsurance = lifeInsuranceRepository.findAll(); // Note : same as save
		return allInsurance;
	}
	@Override
	public LifeInsurance getLifeInsuranceBySumInsured(int sumInsured) throws Exception {
		return  lifeInsuranceRepository.getLifeInsuranceBySumInsured(sumInsured);
	}
	@Override
	public List<LifeInsurance> getLifeInsuranceByPremium(int premium) throws Exception {
	
		return lifeInsuranceRepository.getLifeInsuranceByPremium(premium);
	}
	@Override
	public LifeInsurance updateLifeInsurance(LifeInsurance lifeInsurance) throws Exception{
		return lifeInsuranceRepository.save(lifeInsurance);
	}

	@Override
	public LifeInsurance getLifeInsuranceByInsuranceName(String insuranceName) throws Exception {
		LifeInsurance outPut =  lifeInsuranceRepository.getLifeInsuranceByInsuranceName(insuranceName);
		
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
	public List<LifeInsurance> findLifeInsuranceWithSorting(String field) throws Exception {
		
		return lifeInsuranceRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	

	

	@Override
	public void delete(int hId) throws Exception {
		lifeInsuranceRepository.deleteById(hId);
		
	}

	@Override
	public List<LifeInsurance> sortingBasedOnPremium() throws Exception {
		List<LifeInsurance> list=lifeInsuranceRepository.findAll();
		List<LifeInsurance> lifeInsurances=new ArrayList<>();
		Collections.sort(list,new SortingBasedOnPremiumHighToLow());
		return list;
	}

	

	

	

}//end of class

