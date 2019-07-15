package com.jspl.lms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.dao.DistributorDao;
import com.jspl.lms.dao.UserDao;
import com.jspl.lms.model.Distributor;
import com.jspl.lms.model.Location;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.Role;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserLocationMap;
import com.jspl.lms.model.UserRole;
import com.jspl.lms.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DistributorDao distributorDao;
	
	@Autowired
	private PasswordEncoder encoder;

	@Transactional
	public User loadUserByUsername(String username) {
		User user = userDao.findUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User with username '" + username + "' is not found!");
		}
		return user;
	}

	@Transactional
	public Integer saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user=userDao.saveUser(user);
		return user.getUserPkId();
	}


	@Transactional
	public boolean isUserUniqueByUserName(String username) {
		User user = userDao.findUserByUserName(username);
		if(user!=null && user.getUsername()==username){
			return false;
		}else{
			return true;
		}
		
	}

	@Transactional
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

	@Transactional
	public List<Location> getLocationList() {
		// TODO Auto-generated method stub
		return userDao.getLocationList();
	}

	@Transactional
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return userDao.getRoleList();
	}
	
	@Transactional
	public void saveUserLocationMap(List<Integer> locationList, Integer userRoleId, Integer userId, String userName,
			String password, Integer userRegionId, String validEmail,String name,String contactNumber,String sapId,Integer status,Date registeredDate,String distributorDmsId) {
		
		
		User u = new User();
		u.setUsername(userName);
		u.setPassword(encoder.encode(password));
		u.setUserPkId(userId);	
		u.setDistributorDmsId(distributorDmsId);
		if(userId==null){
		u.setRegisteredDate(new Date());
		u.setStatus(0);
		}else{
			u.setRegisteredDate(registeredDate);
			u.setStatus(status);	
		}
		u.setContactNumber(contactNumber);
		u.setSapId(sapId);
		u.setEmail(validEmail);
		u.setName(name);
		List<UserLocationMap> list = new ArrayList<UserLocationMap>();
		for (Integer locationId : locationList) {
			UserLocationMap userLocationMap = new UserLocationMap();
			userLocationMap.setLocationFkId(locationId);
			userLocationMap.setUserFkId(userId);
			
			userLocationMap.setRegionFkId(userRegionId);
			list.add(userLocationMap);
		}
		u.setLocationList(list);
	
		List<UserRole> l = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setRoleId(userRoleId);
		userRole.setUserFkId(userId);
		l.add(userRole);
		u.setUserRole(l);

		User us=userDao.saveUser(u);
		
		
if(userRoleId==2){
	
	
			if(userId==null  ){
				
				System.out.println("sumitu"+userId);
				Distributor distributor =new Distributor();
				Location loc =new Location();
				distributor.setDistributorName(us.getName());
				distributor.setEmail(us.getEmail());
				distributor.setMobileNo(us.getContactNumber());
				distributor.setSapId(us.getSapId());
				distributor.setDistributorDmsId(us.getDistributorDmsId());
				
				if(us.getLocationList().get(0).getLocationFkId()!=null){
					loc.setLocationPkId(us.getLocationList().get(0).getLocationFkId());
					distributor.setLocationFkId(loc);	
				}
				distributor.setIsDeleted(true);
				distributor.setCreatedOn(new Date());
				
				distributor.setUser(us);
				distributorDao.saveDistributor(distributor);
				
			}else{
				
				System.out.println("sumitc"+us.getUserPkId());
				
				Distributor distributor2= distributorDao.findDistributerByUserId(us.getUserPkId());
				
				Location loc =new Location();
				distributor2.setDistributorName(us.getName());
				distributor2.setEmail(us.getEmail());
				distributor2.setMobileNo(us.getContactNumber());
				distributor2.setSapId(us.getSapId());
				distributor2.setDistributorDmsId(us.getDistributorDmsId());
				if(us.getLocationList().get(0).getLocationFkId()!=null){
					loc.setLocationPkId(us.getLocationList().get(0).getLocationFkId());
					distributor2.setLocationFkId(loc);	
				}
				distributor2.setIsDeleted(true);
				distributor2.setCreatedOn(new Date());
				distributor2.setUser(us);
				distributorDao.saveDistributor(distributor2);
			}
		
			}

	}

	@Override
	public void deleteNullUser(String string) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<Region> getRegionList() {
		// TODO Auto-generated method stub
		return userDao.getRegionList();
	}

	
	@Transactional
	public List<Location> getLocationListByRegionId(Integer userRegionId) {
		
		List<Location> list=null;
		if(userRegionId!=null ){
		list= userDao.getLocationListByRegionId(userRegionId);
		System.out.println("sumit"+userRegionId);
		}else{
			 list=  userDao.getLocationList();
			 System.out.println("sumiat"+userRegionId);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Transactional
	public int forgetPassword(String encPassword, String emailId) {
		// TODO Auto-generated method stub
		return userDao.forgetPassword( encPassword,  emailId);
	}

	@Override
	@Transactional
	public void changePassword(String encPassword, String usernmae) {
		// TODO Auto-generated method stub
		 userDao.changePassword( encPassword,  usernmae);
	}

	@Override
	@Transactional
	public List<User> getUserListByRole(String role) {
		
		return userDao.getUserListByRole(role);
	}


}
