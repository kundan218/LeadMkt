package com.jspl.lms.dao;

import java.util.List;

import com.jspl.lms.model.Location;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.Role;
import com.jspl.lms.model.User;

public interface UserDao {
	
	public User findUserByUserName(String username);
	public User saveUser(User user);
	//public List<User> findAllUsers(); 
	//public boolean isUserUniqueByUserName(Integer userId, String username);
	public List<User> getUserList();
	public List<Location> getLocationList();
	public List<Role> getRoleList();
	public List<Region> getRegionList();
	public List<Location> getLocationListByRegionId(Integer userRegionId);
	public int forgetPassword(String encPassword, String emailId);
	public void changePassword(String encPassword, String usernmae);
	public List<User> getUserListByRole(String role);

}

