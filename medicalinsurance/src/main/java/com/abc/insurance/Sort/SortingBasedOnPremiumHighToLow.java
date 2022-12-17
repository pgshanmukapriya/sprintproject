package com.abc.insurance.Sort;

import java.util.Comparator;

import com.abc.insurance.entity.MedicalInsurance;

public class SortingBasedOnPremiumHighToLow implements Comparator<MedicalInsurance>{

	@Override
	public int compare(MedicalInsurance o1, MedicalInsurance o2) {
		
		return o2.getPremium()-o1.getPremium();
	}
}
