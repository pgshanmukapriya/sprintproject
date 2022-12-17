package com.abc.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.service.TravelInsuranceService;

@RestController
@RequestMapping("/public/ti")
public class PublicWebController {

	@Autowired
	TravelInsuranceService travelInsuranceService;

	@GetMapping("/viewtravelinsurance")
	public List<TravelInsurance> viewAllInsurance() {

		try {
			List<TravelInsurance> allExtractedInsurance = travelInsuranceService.getAllTravelInsurance();

			return allExtractedInsurance;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@GetMapping("/suminsured/{sumInsured}")//public/ti/suminsured/50000
	public TravelInsurance getHomeInsuranceBySumInsured(@PathVariable int sumInsured) throws Exception {

		return travelInsuranceService.getTravelInsuranceBySumInsured(sumInsured);

	}

	@GetMapping("/premium/{premium}")
	public List<TravelInsurance> getTravelInsuranceByPremium(@PathVariable int premium) throws Exception {

		return travelInsuranceService.getTravelInsuranceByPremium(premium);

	}

	@GetMapping("/insurancename/{insuranceName}")///public/ti/insurancename/Minor Accident
	public TravelInsurance getTravelInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception {
		return travelInsuranceService.getTravelInsuranceByInsuranceName(insuranceName);
	}
}
