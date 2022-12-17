package com.abc.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.abc.insurance.dto.ErrorDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.service.MedicalInsuranceService;
import com.abc.insurance.service.MedicalPoliciesService;
import com.abc.insurance.util.MedicalPoliciesDTOConvertor;


import lombok.Value;

@RestController
@RequestMapping("/policy/client/medicalPolicies")
@Validated
public class MedicalPoliciesRestController {
	@Autowired
	MedicalPoliciesService medicalPoliciesService;

	@Autowired
	MedicalInsuranceService medicalInsuranceService;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	// /policy/client/medicalPolicies/addMedicalPolicies/5?clientName=ramesh

	@PostMapping("/addMedicalPolicies/{mId}")//,@RequestParam int userId
	public ResponseEntity<String> addMedicalPolicies(@RequestBody MedicalPolicies medicalPolicies,@PathVariable int mId,@RequestParam String clientName)  {

	

		MedicalInsurance clientSelectedMedicalInsurance = medicalInsuranceService.getInsuranceBymId(mId);
		
		//  InsuranceClient client = aruna code to get client by clientUsername  , through RestTemplate 
		
		medicalPolicies.setMedicalInsurance(clientSelectedMedicalInsurance); // have to be removed and replace with line 52
		medicalPolicies.setClientName(clientName);
		
		
		
		try {
			System.out.println(" --- > " + mylogs);
			mylogs.info("---->>>Inside try of adding medical insurance");
			MedicalPolicies savedPolicies = medicalPoliciesService.addMedicalPolicies(medicalPolicies);
			String responseMsg = savedPolicies.getClientName() + "   save with premium:   "
					+ savedPolicies.getPolicyNumber();
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = " Please, Contact to customer care 1800-250-960 or mail us :- care@gmail.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
	}
	
	

	@GetMapping("/viewAllPolices") // ..localhost:8000/policy/client/medicalPolicies/viewAllPolices
	public List<MedicalPolicies> viewAllMedicalPolicies() {

		try {
			List<MedicalPolicies> allExtractedPolicies = medicalPoliciesService.viewAllPolicies();

			return allExtractedPolicies;

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	@GetMapping("/policiesByPolicyNo") //localhost:8000/policy/client/medicalPolicies/policiesByPolicyNo?r1=300&r2=305
	public List<MedicalPolicies> policiesBetweenPolicyNumber(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return medicalPoliciesService.getMedicalPoliciesBetweenPolicyNumber(r1, r2);
	}

	@GetMapping("/clientname/{clientName}") // localhost:8000/policy/client/medicalPolicies/clientname/Raam...not ex
	public MedicalPolicies getByClientName(@PathVariable String clientName) throws Exception {
		return medicalPoliciesService.getMedicalPoliciesByClientName(clientName);
	}

	@PutMapping("/updateMedicalPolicies") // .........localhost:8000/policy/client/medicalPolicies/updateMedicalPolicies
	public MedicalPolicies updateMedicalPolicies(@RequestBody MedicalPolicies medicalPolicies) throws Exception {

		return medicalPoliciesService.updateMedicalPolicies(medicalPolicies);

	}

	@DeleteMapping("/delete/{medicalPolicyId}") // .....localhost:8000/policy/client/medicalPolicies/delete/2..cannot
											
	public String deleteMedicalPolicies(@PathVariable int medicalPolicyId) throws Exception {
		medicalPoliciesService.delete(medicalPolicyId);
		mylogs.info("Deleted Policies=" + medicalPolicyId + "Data");

		return "Deleted Id=" + medicalPolicyId + "Data";

	}
	

	@GetMapping("/{field}")// .....localhost:8000/policy/client/medicalPolicies/
	public List<MedicalPolicies> getMedicalPoliciesWithSort(@PathVariable String field) throws Exception {
		List<MedicalPolicies> allMedicalPolicies = medicalPoliciesService.findMedicalPoliciesWithSorting(field);
		return allMedicalPolicies;
	}
	
}