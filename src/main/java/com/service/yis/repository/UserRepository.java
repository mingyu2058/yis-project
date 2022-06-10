package com.service.yis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.yis.domain.User.UserEntity;


//DAO
//자동으로 BEAN
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
}