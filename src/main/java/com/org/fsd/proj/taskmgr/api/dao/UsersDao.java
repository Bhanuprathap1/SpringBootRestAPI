package com.org.fsd.proj.taskmgr.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.org.fsd.proj.taskmgr.api.entity.Users;

public interface UsersDao extends CrudRepository<Users, Integer>{

	public static final String FIND_USERS_BY_FIRST_NAME = "SELECT * FROM users where first_name = ?";

	@Query(value = FIND_USERS_BY_FIRST_NAME, nativeQuery = true)
	 List<Users> findUsersByFirstNameStartingWith(String first_name);
}
