package com.jspl.lms.service;

import com.jspl.lms.model.LeadManage;

public interface MailAlertService {

	void sendMailToAssignLeadByRSM(LeadManage leadManage);
	void sendMailToAssignLeadBySO(LeadManage leadManage);
	void sendMailOnCancel(LeadManage leadManage,String role);
	void sendMailToAssignLeadToStockyard(LeadManage leadManage);
	void sendMailToAssignLeadToRsmBulkUpload(LeadManage leadManage);

}
