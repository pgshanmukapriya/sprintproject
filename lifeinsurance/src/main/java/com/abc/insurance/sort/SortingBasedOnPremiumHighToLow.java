package com.abc.insurance.sort;


import java.util.Comparator;

import com.abc.insurance.entity.LifeInsurance;

public class SortingBasedOnPremiumHighToLow   implements Comparator<LifeInsurance>{

	@Override
	public int compare(LifeInsurance o1, LifeInsurance o2) {
		
		return o2.getPremium()-o1.getPremium();
	}

	
}
