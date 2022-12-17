package com.abc.insurance.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


@Entity

public class LifeInsurance {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int lId;

private String insuranceName;
private int premium;
private int sumInsured;
private String isCoveredBelongings;
private  int maxbelongingsAmount;
private  String isCoveredLifeStructure;
private int  lifeStructureAmount;


public LifeInsurance() {
	super();
	// TODO Auto-generated constructor stub
}


public LifeInsurance(int lId, String insuranceName, int premium, int sumInsured, String isCoveredBelongings,
		int maxbelongingsAmount, String isCoveredLifeStructure, int lifeStructureAmount) {
	super();
	this.lId = lId;
	this.insuranceName = insuranceName;
	this.premium = premium;
	this.sumInsured = sumInsured;
	this.isCoveredBelongings = isCoveredBelongings;
	this.maxbelongingsAmount = maxbelongingsAmount;
	this.isCoveredLifeStructure = isCoveredLifeStructure;
	this.lifeStructureAmount = lifeStructureAmount;
}


public int getlId() {
	return lId;
}


public void setlId(int lId) {
	this.lId = lId;
}


public String getInsuranceName() {
	return insuranceName;
}


public void setInsuranceName(String insuranceName) {
	this.insuranceName = insuranceName;
}


public int getPremium() {
	return premium;
}


public void setPremium(int premium) {
	this.premium = premium;
}


public int getSumInsured() {
	return sumInsured;
}


public void setSumInsured(int sumInsured) {
	this.sumInsured = sumInsured;
}


public String getIsCoveredBelongings() {
	return isCoveredBelongings;
}


public void setIsCoveredBelongings(String isCoveredBelongings) {
	this.isCoveredBelongings = isCoveredBelongings;
}


public int getMaxbelongingsAmount() {
	return maxbelongingsAmount;
}


public void setMaxbelongingsAmount(int maxbelongingsAmount) {
	this.maxbelongingsAmount = maxbelongingsAmount;
}


public String getIsCoveredLifeStructure() {
	return isCoveredLifeStructure;
}


public void setIsCoveredLifeStructure(String isCoveredLifeStructure) {
	this.isCoveredLifeStructure = isCoveredLifeStructure;
}


public int getLifeStructureAmount() {
	return lifeStructureAmount;
}


public void setLifeStructureAmount(int lifeStructureAmount) {
	this.lifeStructureAmount = lifeStructureAmount;
}


@Override
public String toString() {
	return "LifeInsurance [lId=" + lId + ", insuranceName=" + insuranceName + ", premium=" + premium + ", sumInsured="
			+ sumInsured + ", isCoveredBelongings=" + isCoveredBelongings + ", maxbelongingsAmount="
			+ maxbelongingsAmount + ", isCoveredLifeStructure=" + isCoveredLifeStructure + ", lifeStructureAmount="
			+ lifeStructureAmount + "]";
}

}
 

