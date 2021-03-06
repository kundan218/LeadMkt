package com.jspl.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.tool.xml.css.parser.State;
import com.jspl.lms.dao.CommonDao;
import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.ReportingDto;
import com.jspl.lms.model.User;
import com.jspl.lms.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService{
	@Autowired
	private CommonDao commonDao;
	
	@Transactional
	public List<State> getStateList(){
		return commonDao.getStateList();
	}

	@Override
	@Transactional
	public Integer getDistributorFkId(Integer userPkId) {
		// TODO Auto-generated method stub
		return commonDao.getDistributorFkId(userPkId);
	}

	@Transactional
	@Override
	public List<CommonConstant> getDataFromCommonConstant(String code) {
		// TODO Auto-generated method stub
		return commonDao.getDataFromCommonConstant(code);
	}

	@Override
	@Transactional
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return commonDao.getCountryList();
	}

	@Override
	@Transactional
	public List<User> getSOList() {
		return commonDao.getSOList();
	}

	@Override
	@Transactional
	public List<User> getRMList() {
		// TODO Auto-generated method stub
		return commonDao.getRMList();
	}

	@Override
	@Transactional
	public LeadSource editSaveLeadSource(LeadSource leadSource) {
		return commonDao.editSaveLeadSource(leadSource);

	}

	@Override
	@Transactional
	public List<LeadSource> getLeadSourceList(String roleName) {
		return commonDao.getLeadSourceList(roleName);

	}

	@Override
	@Transactional
	public boolean deleteLeadSource(Integer leadSourcePkId) {
		return commonDao.deleteLeadSource(leadSourcePkId);

	}
	
	@Override
	@Transactional
	public List<LeadManage> getLeadCountList(String roleName, Integer userId) {
		return commonDao.getLeadCountList(roleName,userId);
	}

	@Override
	@Transactional
	public List<LeadManage> getLeadSourceCount(String roleName, Integer userId) {
		return commonDao.getLeadSourceCount(roleName,userId);
	}

	@Override
	@Transactional
	public List<CommonConstant> getDataFromCommonConstantAccToStatus(String code) {
		return commonDao.getDataFromCommonConstantAccToStatus(code);
	}

	@Override
	@Transactional
	public List<ReportingDto> getRsmList(Integer regionId) {
		return commonDao.getRsmList(regionId);
	}

	@Override
	@Transactional
	public List<ReportingDto> getSoList(Integer regionId) {
		return commonDao.getSoList(regionId);
	}

	@Override
	@Transactional
	public List<ReportingDto> getStockyardList(Integer regionId) {
		return commonDao.getStockyardList(regionId);
	}
}
