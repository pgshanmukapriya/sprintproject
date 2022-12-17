package com.abc.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;

@Service
public interface UserService {

	public User getUserByClientName(String searchClientName)throws Exception;
	public User linkProfile(Profile savedProfile, User alreadySavedUser)throws Exception;
	public User getUserByClientId(int searchedClientId) throws Exception;
    public List<User> getAllUsers() throws Exception;
   
	public void deleteUserById(int UserId);
	public User addUser(User user);
	public User updateUser(User user);
	

	
    





}