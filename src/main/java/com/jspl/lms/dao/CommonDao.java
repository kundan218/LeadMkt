package com.jspl.lms.dao;

import java.util.List;

import com.itextpdf.tool.xml.css.parser.State;
import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.ReportingDto;
import com.jspl.lms.model.User;

public interface CommonDao {

	List<State> getStateList();

	Integer getDistributorFkId(Integer userPkId);

	List<CommonConstant> getDataFromCommonConstant(String code);

	List<Country> getCountryList();

	List<User> getSOList();

	List<User> getRMList();

	LeadSource editSaveLeadSource(LeadSource leadSource);

	List<LeadSource> getLeadSourceList(String roleName);

	boolean deleteLeadSource(Integer leadSourcePkId);

	List<LeadManage> getLeadCountList(String roleName, Integer userId);

	List<LeadManage> getLeadSourceCount(String roleName, Integer userId);

	List<CommonConstant> getDataFromCommonConstantAccToStatus(String code);

	List<ReportingDto> getRsmList(Integer regionId);

	List<ReportingDto> getSoList(Integer regionId);

	List<ReportingDto> getStockyardList(Integer regionId);

}
