package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "policies")
public class MedicalPolicies {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int medicalPolicyId;// medical insurance is the saperate code 

private int PolicyNumber;
@NotNull(message = "policy Name cannot be Null")
private String clientName;
private String dateOfPurchase;
private String dateOfExpire;
private String isClaimed;
private String claimDate;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "MedicalInsurance")
private MedicalInsurance medicalInsurance;


public MedicalPolicies(int policyNumber, @NotNull(message = "policy Name cannot be Null") String clientName,
		String dateOfPurchase, String dateOfExpire, String isClaimed, String claimDate) {
	super();
	this.PolicyNumber = policyNumber;
	this.clientName = clientName;
	this.dateOfPurchase = dateOfPurchase;
	this.dateOfExpire = dateOfExpire;
	this.isClaimed = isClaimed;
	this.claimDate = claimDate;
}



//end of constructor


}//end of class