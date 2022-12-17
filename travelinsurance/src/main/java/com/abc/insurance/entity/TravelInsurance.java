package com.abc.insurance.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TravelInsuranceDetails")
public class TravelInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;

	@NotBlank(message = "Insurance Name  cannot be Blank")
	private String insuranceName;

	@Email(message = "Not a valid email")
	private String email;

	@NotNull(message = "Location cannot be null")
	private String location;

	private String isMedicalNeed;

	private String isLostBelongings;

	private String cancellation;

	private int premium;

	private int sumInsured;
	
	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	
}
