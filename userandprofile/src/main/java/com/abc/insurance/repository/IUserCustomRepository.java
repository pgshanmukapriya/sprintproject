package com.abc.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.User;

@Repository
public interface IUserCustomRepository {
	
	public User getUsersByClientName(String clientName)throws Exception;
	
	@Query("from User where clientId >= :range1 and clientId <= :range2")
	public List<User> getUsersBetweenClientId(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	
	
}