package com.org.fsd.proj.taskmgr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.fsd.proj.taskmgr.api.dao.UsersDao;
import com.org.fsd.proj.taskmgr.api.entity.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	public List<Users> findAllUsers()
	{
		return (List<Users>) usersDao.findAll();
	}

	public Users saveUser(Users users)
	{
		return usersDao.save(users);
	}
	
	public void deleteUser(int user_id)
	{
		usersDao.deleteById(user_id);
	}
	
	public List<Users> findUsersByFirstNameStartingWith(String first_name)
	{
		return usersDao.findUsersByFirstNameStartingWith(first_name);
	}
	
	  public Optional<Users> findByUserID(int user_id)
	  {
	        return usersDao.findById(user_id);
	    }
}
