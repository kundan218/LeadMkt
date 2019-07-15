package com.jspl.lms.dao;

import java.util.List;

import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.model.Distributor;

public interface DistributorDao {

	public Distributor saveDistributor(Distributor distributor);

	List<Distributor> getDistributorList();

	public boolean deleteDistributor(Integer distributorId);
	
	public Distributor findDistributerByUserId(Integer userId);

	public List<Distributor> getDistributorByUserId(Integer userPkId, String roleId);

	public List<Distributor> getDistributorListByUserId(ReportParam param);

}
