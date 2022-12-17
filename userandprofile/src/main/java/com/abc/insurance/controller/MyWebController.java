package com.abc.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.User;
import com.abc.insurance.service.UserService;

@RestController
@RequestMapping("/insurance")
public class MyWebController {

	@Autowired
     UserService userService;



	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}


@PostMapping("/add")

public ResponseEntity<String> addUser(@RequestBody User user) 
{
	
	try {
	User savedUser =  userService.addUser(user);
     String responseMsg = savedUser.getClientName()+" save with Id "+savedUser.getClientId();
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	} catch (Exception e) {
		String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@PutMapping("/update")
public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception
{
     User savedUser =  userService.addUser(user);
	return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	
}
@DeleteMapping("/clientId/{searchClientid}")
public void deleteUserById(@PathVariable int searchClientid) 
{
	try {
		userService.deleteUserById(searchClientid);
		
	  }catch(Exception e){
		  e.printStackTrace();
	  }

}

@GetMapping("/clientName/{searchClientname}")
public User getAllUsersByUserName(@PathVariable String searchClientname)throws Exception
{
	return userService.getUserByClientName(searchClientname);
}

@GetMapping("/clientId/{searchClientid}")
public User getUserById(@PathVariable int searchClientid)throws Exception
{
	
	return userService.getUserByClientId(searchClientid);
	
}


@GetMapping("/allusers")
public List<User> getAllUsers()
{
	
	try {
		List<User>  allExtractedUsers = userService.getAllUsers();
		
		return allExtractedUsers;
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
	
	return null;
}




}
