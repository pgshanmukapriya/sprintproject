package com.abc.insurance.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.repository.MedicalInsuranceRepository;
@SpringBootTest
class MedicalInsuranceServiceImplTest {
	
	@Mock
	MedicalInsuranceRepository medicalInsuranceRepository;
	
	@InjectMocks
	MedicalInsuranceServiceImpl MedicalInsuranceService;
	

	@Test
	@Disabled
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@DisplayName("to verify wheather the insurance added or not")
	void testAddMedicalInsurance() throws Exception{
		// given
		MedicalInsurance sampleInput = new MedicalInsurance(1,"Family", 30000, 4000,50000 , 200000, 6000);
		MedicalInsurance expectedOutput = new MedicalInsurance(1,"Family", 30000, 4000,50000 , 200000, 6000);
				//Object obj = new Object();
				BDDMockito.given(MedicalInsuranceService.addMedicalInsurance(sampleInput)).willReturn(expectedOutput);
				
				// when 
				MedicalInsurance actualOutput = MedicalInsuranceService.addMedicalInsurance(sampleInput);
				
				// verify 
				assertEquals(expectedOutput, actualOutput);
			}



	@Test
	//@Disabled
	@DisplayName("test to verify all insurances returned")
	void testGetAllMedicalInsurance()throws Exception {
		//given
		MedicalInsurance insurance1=new MedicalInsurance(1,"Family", 30000, 4000,50000 , 200000, 6000);
		MedicalInsurance insurance2=new MedicalInsurance(1,"Family", 30000, 4000,50000 , 200000, 6000);
		
		List<MedicalInsurance> sampleOutput =new ArrayList<>();
		sampleOutput.add(insurance1);
		sampleOutput.add(insurance2);
		
      BDDMockito.given(MedicalInsuranceService.getAllMedicalInsurance()).willReturn(sampleOutput);
		
		// ----------------------------------------------------------------------
		
		// when :- readyto test the funcationality (service)
		List<MedicalInsurance> actualOutput = MedicalInsuranceService.getAllMedicalInsurance();
		
		
		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull();  // or
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}
	
	@Test
	@Disabled
	void testGetMedicalInsuranceBySumInsured() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetMedicalInsuranceByPremium() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateMedicalInsurance() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetMedicalInsuranceByInsuranceName() {
		fail("Not yet implemented");
	}

	@Test
	//@Disabled
	@DisplayName("Test to verify the method getMedicalInsurance by Id should return MedicalInsurance or not")
	void testGetInsuranceBymId()throws Exception {
		// give 
		MedicalInsurance sampleOutput = new MedicalInsurance(1,"Family", 30000, 4000,50000 , 200000, 6000);
		sampleOutput.setmId(1);
		
		int sampleInput = 1;
		
		BDDMockito.given(MedicalInsuranceService.getInsuranceBymId(sampleInput)).willReturn(sampleOutput);
		
		// when 
    	MedicalInsurance actualOutput = MedicalInsuranceService.getInsuranceBymId(sampleInput);
		
		// verify
		assertEquals(sampleOutput,actualOutput);
		assertSame(sampleOutput.getmId(), actualOutput.getmId());
		assertThat(actualOutput.getmId()).isGreaterThan(0);
		
	}
	@Test
	@Disabled
	void testFindMedicalInsuranceWithSorting() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSortingBasedOnPremium() {
		fail("Not yet implemented");
	}

}
