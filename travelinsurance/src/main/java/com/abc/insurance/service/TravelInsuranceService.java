package com.abc.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;

@Service
public interface TravelInsuranceService {

	public TravelInsurance insertTravelInsurance(TravelInsurance travelInsurance) throws Exception;

	public TravelInsurance updateTravelInsurance(TravelInsurance travelInsurance) throws Exception;

	public void delete(int tId) throws Exception;

	public List<TravelInsurance> getAllTravelInsurance() throws Exception;
	
	

	public List<TravelInsurance> getTravelInsuranceByPremium(int premium) throws Exception;

	public TravelInsurance getTravelInsuranceByLocation(String location) throws Exception;

	public TravelInsurance getTravelInsuranceBySumInsured(int sumInsured) throws Exception;

	public TravelInsurance getTravelInsuranceByInsuranceName(String insuranceName) throws Exception;

	public TravelInsurance getTravelInsuranceBytId(int tId) throws Exception;

	
	
	
	public List<TravelInsurance> findTravelInsuranceWithSorting(String field) throws Exception;

	public List<TravelInsurance> sortingBasedOnPremium() throws Exception;

	public List<TravelInsurance> filterByInsuranaceName(String insuranceName) throws Exception;

}
