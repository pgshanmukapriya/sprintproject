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

import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.LifeInsurance;
import com.abc.insurance.service.LifeInsuranceService;


@RestController
@RequestMapping("/lifeInsurance")
public class LifeInsuranceWebController {
	@Autowired
	LifeInsuranceService lifeInsuranceService;
	
	
	public  LifeInsuranceWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addLifeInsurance(@RequestBody LifeInsurance lifeInsurance)
	{
		try {
			LifeInsurance savedLifeInsurance = lifeInsuranceService.addLifeInsurance(lifeInsurance);
			String responseMsg = savedLifeInsurance.getInsuranceName()+"save with lId"+savedLifeInsurance.getlId();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch(Exception e) {
			String errorMsg = "Contact to customer care 19876-89-876 or mail us:- care@capg.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.OK);
		}
	}
		
	
	@GetMapping("/viewLifeInsurance")//....localhost:8003/lifeInsurance/viewLifeInsurance
	public List<LifeInsurance> viewAllInsurance()
	{

		try {
			List<LifeInsurance>  allExtractedInsurance =lifeInsuranceService.getAllLifeInsurance();
			
			return allExtractedInsurance;
			
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		return null;
	}
	@GetMapping("/sumInsured/{sumInsured}")//....localhost:8009/safeInsurance/admin/lifeInsurance/sumInsured/1000000
	public LifeInsurance getLifeInsuranceBySumInsured(@PathVariable int sumInsured)throws Exception
	{
		
		return lifeInsuranceService.getLifeInsuranceBySumInsured(sumInsured);
		
	}
	@GetMapping("/premium/{premium}")//.........localhost:8009/safeInsurance/admin/lifeInsurance/premium/7000 
	public List<LifeInsurance> getLifeInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return  lifeInsuranceService.getLifeInsuranceByPremium(premium);
		
	}
	@GetMapping("/insuranceName/{name}")//..localhost:8009/safeInsurance/admin/lifeInsurance/insuranceName/
    public LifeInsurance getLifeInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return lifeInsuranceService.getLifeInsuranceByInsuranceName(insuranceName);
    }
    @PutMapping("/update")//.........localhost:8003/LifeInsurance/update
	public LifeInsurance updateLifeInsurance(@RequestBody LifeInsurance lifeInsurance)throws Exception
	{
return lifeInsuranceService.updateLifeInsurance(lifeInsurance);
		
		
	}
    @DeleteMapping("/delete/{lId}")//.....localhost:8009/safeInsurance/admin/lifeInsurance/delete/5..cannot do bcoz of foreign key
    public String deleteInsurance(@PathVariable int lId) 
    {
    	try {
    		lifeInsuranceService.delete(lId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	mylogs.info("Deleted Insurance=" +lId+"Data");
		return "Deleted Id="+lId+"Data";
    }
    @GetMapping("/{field}")//..localhost:8009/safeInsurance/admin/lifeInsurance/premium
    public List<LifeInsurance> getLifeInsuranceWithSort(@PathVariable String field) throws Exception
    {
    	List<LifeInsurance> allLifeInsurance=lifeInsuranceService.findLifeInsuranceWithSorting(field);
    	return allLifeInsurance;
    }
   @GetMapping("/sort/premium")
   public List<LifeInsurance> getBySorting() throws Exception
	    {
	    	List<LifeInsurance> allLifeInsurance=lifeInsuranceService.sortingBasedOnPremium();
	    	return allLifeInsurance;
	    }
   
    
}//end of class