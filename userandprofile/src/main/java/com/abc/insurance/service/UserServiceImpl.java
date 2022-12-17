package com.abc.insurance.service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;
import com.abc.insurance.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() throws Exception {

		List<User> allUsers =  userRepository.findAll(); // Note : same as save
		return allUsers;
		// TODO Auto-generated method stub
	}
	@Override
	public User getUserByClientName(String clientName) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUsersByClientName(clientName);
	}


	@Override
	@Transactional
	public User linkProfile(Profile profile, User clientName) {

		clientName.setUserProfile(profile);
		return clientName;

	}

	@Override
	public User getUserByClientId(int searchedClientId) throws Exception {
		 User outputUser = userRepository.getById(searchedClientId);
		 return outputUser;
	}
	@Override
	public void deleteUserById(int UserId) {
			// TODO Auto-generated method stub
			userRepository.deleteById( UserId);
	}

		
  @Override
	public User updateUser(User user) {
	User update = userRepository.save(user);
		return update;

	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
				return userRepository.save(user);
	}

	


}