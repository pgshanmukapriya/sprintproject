package com.abc.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;
import com.abc.insurance.service.ProfileService;
import com.abc.insurance.service.UserService;


@RestController
@RequestMapping("/profile")
@Validated
public class ProfileWebController {

	@Autowired
	ProfileService profileService;

	@Autowired
	UserService userService;

	@PostMapping("/add/{cid}") //localhost:8002/profile/add/2?clientName=Raam
	public User doProfileThings(@RequestBody Profile profile,@RequestParam String clientName)
	{
		User alreadySavedUser = null;
		try
		{
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedUser = userService.getUserByClientName(clientName);
				if(alreadySavedUser != null)
				{
					User profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);

					return profileAddUser;
				}
				else
				{
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+clientName);
				}

			}
		}
		catch (Exception e) {
			System.out.println(e);
			return alreadySavedUser;
		}

		return alreadySavedUser;

		// code to add the profile
	}

}