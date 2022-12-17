package com.abc.insurance.sorting;

import java.util.Comparator;

import com.abc.insurance.entity.TravelPolicy;

public class SortingBasedOnPolicyNoHighToLow implements Comparator<TravelPolicy> {

	@Override
	public int compare(TravelPolicy o1, TravelPolicy o2) {
		return o2.getPolicyNumber() - o1.getPolicyNumber();
	}

}
