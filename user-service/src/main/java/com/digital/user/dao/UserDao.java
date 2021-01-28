package com.digital.user.dao;

import java.util.Optional;

import com.digital.user.entity.UserInformation;
import com.digital.user.exception.UserFetchingException;
import com.digital.user.exception.UserPersistingException;

public interface UserDao {

	Optional<UserInformation> fetchUserByUserId(String userId) throws UserFetchingException;

	void updateUserProfile(UserInformation userInformation) throws UserPersistingException;

	void saveUser(UserInformation newUser) throws UserPersistingException;
}
