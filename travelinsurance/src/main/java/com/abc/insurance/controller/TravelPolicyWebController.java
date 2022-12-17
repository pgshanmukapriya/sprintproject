package com.abc.insurance.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.service.TravelInsuranceService;
import com.abc.insurance.service.TravelPolicyService;
import com.abc.insurance.util.TravelPolicyDTOConvertor;

@RestController
@RequestMapping("client/policy")
public class TravelPolicyWebController {

	@Autowired
	TravelPolicyService travelPolicyService;

	@Autowired
	TravelInsuranceService travelInsuranceService;

	@Autowired
	DefaultResponseDTO dtoConvertor;

	@Autowired
	TravelPolicyDTOConvertor tpDTOConvertor;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/addpolicy/{tId}") // 8005/client/policy/addpolicy/1?clientName=sam
	public ResponseEntity<MyDTO> addPolicy(@RequestBody TravelPolicy travelPolicy, @PathVariable int tId,
			@RequestParam String clientName) throws Exception {

		TravelInsurance clientSelectedTravelInsurance = travelInsuranceService.getTravelInsuranceBytId(tId);
		travelPolicy.setTravelInsurance(clientSelectedTravelInsurance); 
		travelPolicy.setClientName(clientName);

		System.out.println(" --- > " + mylogs);

		mylogs.info("---->>>Inside adding Travel Policy");

		TravelPolicy savedTravelPolicy = travelPolicyService.addTravelPolicy(travelPolicy);

		DefaultResponseDTO responseDTO = tpDTOConvertor.getTravelInsuranceDefaultResponseDTO(savedTravelPolicy);
		return new ResponseEntity<MyDTO>(responseDTO, HttpStatus.OK);

	}// end of addPolicy

	@GetMapping("/viewallpolicies") // localhost:8005/client/policy/viewallpolicies
	public List<TravelPolicy> viewAllPolicy() {

		try {

			List<TravelPolicy> allpolicies = travelPolicyService.viewAllPolicy();

			return allpolicies;

		} catch (Exception e) {

			System.out.println(e);
		}
		return null;

	}// end of viewPolicy
	

	@PutMapping("/update") // localhost:8005/client/policy/update
	public TravelPolicy updateTravelPolicy(@RequestBody TravelPolicy travelPolicy) throws Exception {

		return travelPolicyService.updateTravelPolicy(travelPolicy);

	}
	
	@DeleteMapping("/delete/{policyId}") // 8005/client/policy/delete/3
	public String deleteTravelPolicy(@PathVariable int policyId) throws Exception {

		try {
			travelPolicyService.delete(policyId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		mylogs.info("Deleted  = " + policyId + " Data");
		return "Deleted Id = " + policyId + " Data";
	}
	
	@GetMapping("/policyNumber") // localhost:8005/client/policy/policyNumber?r1=600&r2=601
	public List<TravelPolicy> policiesBetweenPolicyNumber(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return travelPolicyService.getTravelPolicyBetweenPolicyNumber(r1, r2);
	}

	@GetMapping("/clientname/{clientName}") // localhost:8005/client/policy/clientname/anu
	public TravelPolicy getByClientName(@PathVariable String clientName) throws Exception {

		return travelPolicyService.getTravelPolicyByClientName(clientName);
	}

	@GetMapping("/sort/{field}") // ...8005/client/policy/sort/clientName
	public List<TravelPolicy> getTravelPolicyWithSort(@PathVariable String field) throws Exception {

		List<TravelPolicy> allTravelPolicy = travelPolicyService.findTravelPolicyWithSorting(field);

		return allTravelPolicy;
	}

	@GetMapping("/filterclientname/{clientName}") // ...8005/client/policy/filterclientname/sam
	public List<TravelPolicy> filterByClientName(@PathVariable String clientName) throws Exception {
		List<TravelPolicy> allfilteredClientName = travelPolicyService.filterByClientName(clientName);
		return allfilteredClientName;
	}

	@GetMapping("/sort/policynumber") // localhost:8005/client/policy/sort/policyNumber
	public List<TravelPolicy> getBySorting() throws Exception {
		List<TravelPolicy> allTravelPolicies = travelPolicyService.sortingBasedOnPolicyNumber();
		return allTravelPolicies;
	}

}
