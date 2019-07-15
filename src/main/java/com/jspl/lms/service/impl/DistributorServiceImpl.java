package com.jspl.lms.service.impl;

import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.dao.DistributorDao;
import com.jspl.lms.dao.UserDao;
import com.jspl.lms.model.Distributor;
import com.jspl.lms.service.DistributorService;
import com.jspl.lms.service.MailAlertService;
@Service
public class DistributorServiceImpl implements DistributorService{

	@Autowired 
	private DistributorDao distributorDao;
	
	@Autowired
	private MailAlertService mailAlertService;
	
	@Autowired
	private UserDao  userDao;
	
	String role=null;
	
	static ResourceBundle bundle = ResourceBundle.getBundle("mail");
	Double stockTotal=0.00;
	Double normsTotal=0.00;
	
	@Transactional
	@Override
	public Distributor saveDistributor(Distributor distributor) {
		//UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		distributor.setIsDeleted(true);
		//User user2=new User();
		//user2.setUserPkId(user.getUserPkId());
		//distributor.setUser(user2);
	//	distributor.setSalesOfficer(user.getName());
		return distributorDao.saveDistributor(distributor);
	}

	@Override
	@Transactional
	public List<Distributor> getDistributorList() {
		return distributorDao.getDistributorList();
	}

	
	@Transactional
	@Override
	public boolean deleteDistributor(Integer distributorId) {
		return distributorDao.deleteDistributor(distributorId);
	}
	@Transactional
	@Override
	public Distributor findDistributerByUserId(Integer userId) {
		return distributorDao.findDistributerByUserId(userId);
	}

	@Override
	@Transactional
	public List<Distributor> getDistributorByUserId(Integer userPkId,String roleId) {
		return distributorDao.getDistributorByUserId(userPkId,roleId);
	}

	
}
