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
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.repository.MedicalPoliciesRepository;
@SpringBootTest
class MedicalPoliciesServiceImplTest {
     
	@Mock
	MedicalPoliciesRepository medicalPoliciesRepository;
	
	@InjectMocks
	MedicalPoliciesServiceImpl medicalPoliciesService;
	
	@Test
	@DisplayName("to verify wheather the insurance added or not")
	void testAddMedicalPolicies()throws Exception {
		// given
		MedicalPolicies sampleInput = new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
		MedicalPolicies expectedOutput = new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
				//Object obj = new Object();
				BDDMockito.given(medicalPoliciesService.addMedicalPolicies(sampleInput)).willReturn(expectedOutput);
				
				// when 
				MedicalPolicies actualOutput = medicalPoliciesService.addMedicalPolicies(sampleInput);
				
				// verify 
				assertEquals(expectedOutput, actualOutput);
			}



	@Test
	@DisplayName("test to verify all policies returned")
	void testViewAllPolicies()throws Exception {
		//given 
		MedicalPolicies policies1 = new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
		policies1.setMedicalInsurance(null);
		MedicalPolicies policies2 = new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
		policies2.setMedicalInsurance(null);
		
		List<MedicalPolicies> sampleOutput = new ArrayList<>();
		sampleOutput.add(policies1);
		sampleOutput.add(policies2);
		
		
		BDDMockito.given(medicalPoliciesService.viewAllPolicies()).willReturn(sampleOutput);
		//---------------------------------------------------------------------------------------
		//when:-ready to test the functionality(service)
      List<MedicalPolicies> actualOutput = medicalPoliciesService.viewAllPolicies();
		
		
		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull();  // or
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}
	

	@Test
	@DisplayName("Test to check policies between policyNumber")
	void testGetMedicalPoliciesBetweenPolicyNumber()throws Exception {
		// give

		MedicalPolicies policies1=new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
		policies1.setMedicalInsurance(null);


		MedicalPolicies policies2=new MedicalPolicies(300,"Sai","2/03/2022","3/03/2023","4/04/2022","3/03/2022");
		policies2.setMedicalInsurance(null);

		List<MedicalPolicies> sampleOutput = new ArrayList<>();
		sampleOutput.add(policies1);
		sampleOutput.add(policies2);

		int sampleInput1 = 300;
		int sampleInput2 = 350;


		BDDMockito.given(medicalPoliciesService.getMedicalPoliciesBetweenPolicyNumber(sampleInput1, sampleInput2)).willReturn(sampleOutput);
		


		// when

		List<MedicalPolicies> actualOutput = medicalPoliciesService.getMedicalPoliciesBetweenPolicyNumber(sampleInput1, sampleInput2);


		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);
		}
	

	@Test
	@Disabled
	void testGetMedicalPoliciesByClientName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testLinkMedicalInsurance() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateMedicalPolicies() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindMedicalPoliciesWithSorting() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDelete() {
		fail("Not yet implemented");
	}

}
