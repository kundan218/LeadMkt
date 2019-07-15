package com.jspl.lms.service;

import java.util.Date;
import java.util.List;

import com.jspl.lms.model.Location;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.Role;
import com.jspl.lms.model.User;


public interface UserService {
	
	public User loadUserByUsername(String username);
	public Integer saveUser(User user);
	boolean isUserUniqueByUserName(String username);
	public List<User> getUserList();
	public List<Location> getLocationList();
	public List<Role> getRoleList();
	public void saveUserLocationMap(List<Integer> locationList, Integer userRoleId, Integer userFkId, String userName,
			String password, Integer userRegionId, String validEmail,String name,String contactNumber, String sapId, Integer status, Date registeredDate, String distributorDmsId);
	public void deleteNullUser(String string);
	public List<Region> getRegionList();
	public List<Location> getLocationListByRegionId(Integer userRegionId);
	public int forgetPassword(String encPassword, String emailId);
	public void changePassword(String encPassword, String usernmae);
	public List<User> getUserListByRole(String role);

}