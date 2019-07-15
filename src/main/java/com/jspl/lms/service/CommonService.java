package com.jspl.lms.service;

import java.util.List;

import com.itextpdf.tool.xml.css.parser.State;
import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.ReportingDto;
import com.jspl.lms.model.User;

public interface CommonService {

		public List<State> getStateList();

		public Integer getDistributorFkId(Integer userPkId);
		
		List<CommonConstant> getDataFromCommonConstant(String code);

		public List<Country> getCountryList();

		public List<User> getSOList();

		public List<User> getRMList();

		public LeadSource editSaveLeadSource(LeadSource leadSource);

		public List<LeadSource> getLeadSourceList(String roleName);

		public boolean deleteLeadSource(Integer leadSourcePkId);
		
		public List<LeadManage> getLeadCountList(String roleName, Integer userId);

		public List<LeadManage> getLeadSourceCount(String roleName, Integer userId);
		
		public List<CommonConstant> getDataFromCommonConstantAccToStatus(String code);

		public List<ReportingDto> getRsmList(Integer regionId);

		public List<ReportingDto> getSoList(Integer regionId);

		public List<ReportingDto> getStockyardList(Integer regionId);

}
