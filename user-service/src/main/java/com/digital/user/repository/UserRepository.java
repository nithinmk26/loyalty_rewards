package com.digital.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.user.entity.UserInformation;

@Repository
public interface UserRepository extends JpaRepository<UserInformation, String>{

}
