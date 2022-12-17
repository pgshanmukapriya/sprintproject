package com.abc.insurance.entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="UserInsurance")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;

    private String clientName;
   


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile")
    private Profile userProfile;



	public int getClientId() {
		return clientId;
	}



	public void setClientId(int clientId) {
		this.clientId = clientId;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public User(String clientName) {
		super();
		this.clientName = clientName;
		
	}



	public Profile getUserProfile() {
		return userProfile;
	}



	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}



		
	




}