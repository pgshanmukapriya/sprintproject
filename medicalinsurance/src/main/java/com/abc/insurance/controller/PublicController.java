package com.abc.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.service.MedicalInsuranceService;

@RestController
@RequestMapping("/public/insurance")
public class PublicController {
	@Autowired
	MedicalInsuranceService medicalInsuranceService;
	
	@GetMapping("/viewMedicalInsurance")//....localhost:8000/public/insurance/viewMedicalInsurance
	public List<MedicalInsurance> viewAllInsurance()
	{

		try {
			List<MedicalInsurance>  allExtractedInsurance = medicalInsuranceService.getAllMedicalInsurance();
			
			return allExtractedInsurance;
			
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("/sumInsured/{sumInsured}")//....localhost:8000/safeInsurance/admin/medicalInsurance/sumInsured/1000000
	public MedicalInsurance getMedicalInsuranceBySumInsured(@PathVariable int sumInsured)throws Exception
	{
		
		return medicalInsuranceService.getMedicalInsuranceBySumInsured(sumInsured);
		
	}
	
	@GetMapping("/premium/{premium}")//.........localhost:8000/safeInsurance/admin/medicalInsurance/premium/7000
	public List<MedicalInsurance> getMedicalInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return medicalInsuranceService.getMedicalInsuranceByPremium(premium);
		
	}
	
	
    @GetMapping("/insuranceName/{name}")
    public MedicalInsurance getMedicalInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return medicalInsuranceService.getMedicalInsuranceByInsuranceName(insuranceName);
    }

}