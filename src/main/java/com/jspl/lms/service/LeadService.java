package com.jspl.lms.service;

import java.util.List;

import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadManageDto;
import com.jspl.lms.model.Location;
import com.jspl.lms.model.Material;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.State;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserInfo;

public interface LeadService {

	LeadManage saveLead(LeadManage leadManage);

	List<Country> getCountry();

	List<State> getState();

	List<Location> getDistrict(Integer stateFkId);

	List<Region> getRegion();

	List<Material> getMaterial(Integer sbuFkId);

	Integer getAssignedRsm(Integer regionId);

	LeadManage getLeadDetails(Integer leadManagePkId);

	void cancelLead(Integer leadManagePkId,Integer status, String comment);

	List<Location> getLocationList();

	List<User> getSmList();

	void assignLeadByRsm(Integer leadManagePkId, Integer status, Integer userPkId, String roleList);

	void assignLeadActionByRsm(Integer leadManagePkId, Integer action, String comment);

	List<User> getStockyardList();

	void assignLeadActionBySales(Integer leadManagePkId, Integer smPkId,Integer status);
	
	Integer getCommonConstantValue(String commonConstantValue);

}
