package com.abc.insurance.controller;


import java.util.List;

import javax.validation.Valid;

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
import com.abc.insurance.dto.ErrorDTO;
import com.abc.insurance.dto.InsuranceReponseDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.service.MedicalInsuranceService;
import com.abc.insurance.service.MedicalPoliciesService;
import com.abc.insurance.util.MedicalInsuranceDTOConvertor;
import com.abc.insurance.util.MedicalPoliciesDTOConvertor;




@RestController
@RequestMapping("/safeInsurance/admin/medicalInsurance")
public class MedicalInsuranceWebController {
	@Autowired
	MedicalInsuranceService medicalInsuranceService;
	
	@Autowired
	MedicalPoliciesService medicalPoliciesService;
	
	@Autowired
	MedicalPoliciesDTOConvertor dtoConvertor;
	
	@Autowired
	MedicalInsuranceDTOConvertor hiDTOConvertor;
	
	public  MedicalInsuranceWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	
	
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/addinsurance")  // ....../localhost:8000/safeInsurance/admin/medicalInsurance/addinsurance
	public ResponseEntity<MyDTO> doMedicalInsuranceThings(@RequestBody @Valid MedicalInsurance medicalInsurance)throws Exception
	{
		System.out.println("\n\n--->> Inside controller HI  :- "+medicalInsurance);
	    MedicalInsurance  savedInsurance = medicalInsuranceService.addMedicalInsurance(medicalInsurance);
		InsuranceReponseDTO respDTO  = hiDTOConvertor.convertToDTO(savedInsurance);
		return new ResponseEntity<MyDTO>(respDTO, HttpStatus.OK);
		
	
	
		
	
	}// end post to add medical Insurance 
	

	@GetMapping("/viewMedicalInsurance")//....localhost:8000/safeInsurance/admin/medicalInsurance/viewMedicalInsurance
	public List<MedicalInsurance> viewAllInsurance()
	{

		try {
			List<MedicalInsurance>  allExtractedInsurance =medicalInsuranceService.getAllMedicalInsurance();
			
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
	
	@GetMapping("/premium/{premium}")//.........localhost:8000/safeInsurance/admin/medicalInsurance/premium/70000
	public List<MedicalInsurance> getMedicalInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return  medicalInsuranceService.getMedicalInsuranceByPremium(premium);
		
	}
	
	
    @GetMapping("/iName/{insuranceName}")//..localhost:8000/safeInsurance/admin/medicalInsurance/iName/Accident
    public MedicalInsurance getMedicalInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return medicalInsuranceService.getMedicalInsuranceByInsuranceName(insuranceName);
    }
    @PutMapping("/update")//.........localhost:8000/safeInsurance/admin/medicalInsurance/update
	public MedicalInsurance updateMedicalInsurance(@RequestBody MedicalInsurance medicalInsurance)throws Exception
	{
		
		return medicalInsuranceService.updateMedicalInsurance(medicalInsurance);
		
		
	}
    @DeleteMapping("/delete/{mId}")//.....localhost:8000/safeInsurance/admin/medicalInsurance/delete/5..cannot do bcoz of foreign key
    public String deleteInsurance(@PathVariable int mId) 
    {
    	try {
			medicalInsuranceService.delete(mId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	mylogs.info("Deleted Insurance=" +mId+"Data");
		return "Deleted Id="+mId+"Data";
    	
    }
    @GetMapping("/{field}")//..localhost:8000/safeInsurance/admin/medicalInsurance/premium
    public List<MedicalInsurance> getMedicalInsuranceWithSort(@PathVariable String field) throws Exception
    {
    	List<MedicalInsurance> allMedicalInsurance= medicalInsuranceService.findMedicalInsuranceWithSorting(field);
    	return allMedicalInsurance;
    }
   @GetMapping("/sort/premium")//..localhost:8000/safeInsurance/admin/medicalInsurance/sort/premium
   public List<MedicalInsurance> getBySorting() throws Exception
	    {
	    	List<MedicalInsurance> allMedicalInsurance=medicalInsuranceService.sortingBasedOnPremium();
	    	return allMedicalInsurance;
	    }
   
    
    
}//end of class