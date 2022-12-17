package com.mkj.car.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mkj.car.entity.CarInsurance;
import com.mkj.car.repository.CarInsuranceRepository;
import com.mkj.car.sort.SortingBasedOnPremiumHighToLow;

@Service
public class CarInsuranceServiceImpl implements CarInsuranceService {
	@Autowired
	CarInsuranceRepository carinsuranceRepository;


	@Override
	@Transactional
	public CarInsurance addCarInsurance(CarInsurance carInsurance) throws Exception {
		// TODO Auto-generated method stub

		CarInsurance savedCarInsurance = carinsuranceRepository.save(carInsurance); // Note : save() is already
																					// implemented by Spring Data JPA
		if (savedCarInsurance != null) {
			return savedCarInsurance;
		} else
			return null;


	}

	@Override
	public List<CarInsurance> getAllCarInsurance() throws Exception {
		// TODO Auto-generated method stub
		List<CarInsurance> allInsurance = carinsuranceRepository.findAll(); // Note : same as save
		return allInsurance;
		
	}

	@Override
	public CarInsurance getCarInsuranceBySumInsured(int sumInsured) throws Exception {
		// TODO Auto-generated method stub
		return carinsuranceRepository.getCarInsuranceBysumInsured(sumInsured);
	
	}

	@Override
	public CarInsurance getCarInsuranceByInsuranceName(String insuranceName) throws Exception {
		// TODO Auto-generated method stub
		 CarInsurance outPut =  carinsuranceRepository.getCarInsuranceByInsuranceName(insuranceName);

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
	public List<CarInsurance> getCarInsuranceByPremium(int premium) throws Exception {
		// TODO Auto-generated method stub
		return carinsuranceRepository.getAllCarInsuranceByPremium(premium);
		
	}

	@Override
	public CarInsurance updateCarInsurance(CarInsurance carInsurance) throws Exception {
		// TODO Auto-generated method stub
		return carinsuranceRepository.save(carInsurance);
		
	}

	@Override
	public List<CarInsurance> findCarInsuranceWithSorting(String field) throws Exception {
		// TODO Auto-generated method stub
		return carinsuranceRepository.findAll(Sort.by(Sort.Direction.ASC, field));
		
	}

	@Override
	public List<CarInsurance> filterByInsuranaceName(String insuranceName) throws Exception {
		// TODO Auto-generated method stub


		List<CarInsurance> allfilteredInsurancceName = getAllCarInsurance().stream()
				.filter((insurance) -> insurance.getInsuranceName().equals(insuranceName)).collect(Collectors.toList());
		return allfilteredInsurancceName;
		
	}

	@Override
	public CarInsurance getInsuranceById(int id) {
		// TODO Auto-generated method stub
		return carinsuranceRepository.getReferenceById(id);
		
	}

	@Override
	public List<CarInsurance> sortingBasedOnPremium() throws Exception {
		// TODO Auto-generated method stub
		List<CarInsurance> list=carinsuranceRepository.findAll();
		List<CarInsurance> carInsurances=new ArrayList<>();
		Collections.sort(list,new SortingBasedOnPremiumHighToLow());
		return list;
	
	}

	@Override
	public void delete(int cId) throws Exception {
		// TODO Auto-generated method stub
		carinsuranceRepository.deleteById(cId);
		
	}

}
