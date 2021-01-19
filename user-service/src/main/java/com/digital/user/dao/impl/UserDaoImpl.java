package com.digital.user.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.user.dao.UserDao;
import com.digital.user.entity.UserInformation;
import com.digital.user.exception.UserFetchingException;
import com.digital.user.exception.UserPersistingException;
import com.digital.user.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<UserInformation> fetchUserByUserId(String userId) throws UserFetchingException {
		try{
			return userRepository.findById(userId);
		}
		catch (Exception e) {
			throw new UserFetchingException(String.format("Unable to find user with user id - %s", userId));
		}
	}

	@Override
	public void updateUserProfile(UserInformation userInformation) throws UserPersistingException  {
		try{
			userRepository.saveAndFlush(userInformation);
		}
		catch (Exception e) {
			throw new UserPersistingException(String.format("Unable to update UserProfile with user ID - %s", userInformation.getUserId()));
		}
	}

	@Override
	public void saveUser(UserInformation newUser) throws UserPersistingException {
		try{
			userRepository.save(newUser);
		}
		catch (Exception e) {
			throw new UserPersistingException(String.format("Unable to Persist UserProfile with user ID - %s", newUser.getUserId()));
		}
		
	}

	
	
}
