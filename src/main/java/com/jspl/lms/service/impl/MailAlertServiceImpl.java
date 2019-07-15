package com.jspl.lms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.dao.MailAlertDao;
import com.jspl.lms.dto.EmailDto;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadMaterialMap;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserInfo;
import com.jspl.lms.service.MailAlertService;
import com.jspl.lms.util.DateUtility;
import com.jspl.lms.util.MailUtil;
@Service
public class MailAlertServiceImpl implements MailAlertService{
	@Autowired
	private MailAlertDao mailAlertDao;
	
	static ResourceBundle bundle = ResourceBundle.getBundle("mail");

	@Override
	@Transactional
	public void sendMailToAssignLeadByRSM(LeadManage leadManage) {
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			EmailDto param=new EmailDto();
			param.setDistFkId(leadManage.getLeadManagePkId());
			param=mailAlertDao.getEmailForRSM(param);
			String subject = "Lead Assign | Lead NO: "+leadManage.getLeadId();
			List<LeadMaterialMap> leadMaterialMapList=leadManage.getLeadMaterialMaps();
			String body1="Dear Team,  <br><br>This is for your information that a Lead assigned by you, raised on date "+DateUtility.dateToString(new Date())+". Below the details of the Lead.<br><br>";

			String body4="<table cellpadding='0' cellspacing='0' style=' min-height:500px; padding:2%; width:650px;'><tr><td><tbody>"
					+ "<tr><td><table width='100%' cellpadding='5' cellspacing='0' border='0' style='border:1px solid #eeeeee;'>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead&nbsp;Id:</strong></td>"
					+ "<td colspan='3' style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadId()+"</td> "
					+ "</tr> "
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Name:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getName()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Email Id:</strong></td>"
					
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getEmail()+"</td></tr>"
					
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Mobile:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getMobile()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Source of Lead:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadSourceFkId().getCompanyName()+"</td></tr>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead Type:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadTypeFkId().getCommonConstantValue()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Region:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16x;'>"+leadManage.getRegionFkId().getRegionName()+"</td></tr>"
					+ "</table></td></tr></tbody></td></tr></table>";
			
			String body3="<br><br> For more detail kindly visit to the portal. <br>"
					 +"URL: http://worksmart.jindalpanther.com/LeadMkt/login<br><br><br> Thanks,<br> TEAM JSPL";

					

			String body=body1+body4+body3;
			System.out.println(body);
			List<String> toUser=new ArrayList<String>();
		//	toUser.add("kundan.kumar@jindalsteel.com");
			toUser.add(param.getRmEmail());
			ResourceBundle bundle=ResourceBundle.getBundle("mail");
			List<String> bccUser=new ArrayList<String>();
			
			String[] bccUserArr=bundle.getString("bcc.user").split(",");
			for (String bccUsr : bccUserArr) {
				bccUser.add(bccUsr);
			}
			//bccUser.add(bundle.getString("bcc.user"));
			System.out.println(bundle.getString("bcc.user")+"----------------------------FROM USER");
			String fromUser=bundle.getString("from.user");
			List<String> ccUser=new ArrayList<String>();
			
		//	String[] ccUserArr=bundle.getString("cc.user").split(",");
			
			ccUser.add(bundle.getString("cc.user"));
			System.out.println(ccUser+"----------------------------FROM USER");
			MailUtil.sendMail(fromUser, toUser, ccUser, bccUser, subject, body, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	@Transactional
	public void sendMailToAssignLeadBySO(LeadManage leadManage){
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			EmailDto param=new EmailDto();
			param.setDistFkId(leadManage.getLeadManagePkId());
			param=mailAlertDao.getEmailForRSM(param);
			String subject = "Lead Assign | Lead NO: "+leadManage.getLeadId();
			String body1="Dear Team,  <br><br>This is for your information that a Lead assigned by you, raised on date "+DateUtility.dateToString(new Date())+". Below the details of the Lead.<br><br>";
			String body4="<table cellpadding='0' cellspacing='0' style=' min-height:500px; padding:2%; width:650px;'><tr><td><tbody>"
					+ "<tr><td><table width='100%' cellpadding='5' cellspacing='0' border='0' style='border:1px solid #eeeeee;'>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead&nbsp;Id:</strong></td>"
					+ "<td colspan='3' style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadId()+"</td> "
					+ "</tr> "
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Name:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getName()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Email Id:</strong></td>"
					
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getEmail()+"</td></tr>"
					
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Mobile:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getMobile()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Source of Lead:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadSourceFkId().getCompanyName()+"</td></tr>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead Type:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadTypeFkId().getCommonConstantValue()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Region:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16x;'>"+leadManage.getRegionFkId().getRegionName()+"</td></tr>"
					+ "</table></td></tr></tbody></td></tr></table>";
			
			String body3="<br><br> For more detail kindly visit to the portal. <br>"
					 +"URL: http://worksmart.jindalpanther.com/LeadMkt/login<br><br><br> Thanks,<br> TEAM JSPL";			
			String body=body1+body4+body3;
			System.out.println(body);
			/*List<String> toUser=new ArrayList<String>();
		//	toUser.add("kundan.kumar@jindalsteel.com");
			toUser.add(param.getRmEmail());*/
			User currentUser=user.getUserDetail();
			List<String> toUser=new ArrayList<String>();
			toUser.add(leadManage.getSoAssignFkId().getEmail());
			String fromUser=currentUser.getEmail();
			ResourceBundle bundle=ResourceBundle.getBundle("mail");
			List<String> bccUser=new ArrayList<String>();
			
			String[] bccUserArr=bundle.getString("bcc.user").split(",");
			for (String bccUsr : bccUserArr) {
				bccUser.add(bccUsr);
			}
			//bccUser.add(bundle.getString("bcc.user"));
			System.out.println(bundle.getString("bcc.user")+"----------------------------FROM USER");
			//String fromUser=bundle.getString("from.user");
			List<String> ccUser=new ArrayList<String>();
			
		//	String[] ccUserArr=bundle.getString("cc.user").split(",");
			
			//ccUser.add(bundle.getString("cc.user"));
		//	System.out.println(ccUser+"----------------------------FROM USER");
			MailUtil.sendMail(fromUser, toUser, ccUser, bccUser, subject, body, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void sendMailOnCancel(LeadManage leadManage, String role){
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			EmailDto param=new EmailDto();
			param.setDistFkId(leadManage.getLeadManagePkId());
			param=mailAlertDao.getEmailForRSM(param);
			String subject = "Lead cancelled | Lead NO: "+leadManage.getLeadId();
			String body1="Dear Team,  <br><br>This is for your information that a Lead assigned by you, raised on date "+DateUtility.dateToString(new Date())+". Below the details of the Lead.<br><br>";
			String body4="<table cellpadding='0' cellspacing='0' style=' min-height:500px; padding:2%; width:650px;'><tr><td><tbody>"
					+ "<tr><td><table width='100%' cellpadding='5' cellspacing='0' border='0' style='border:1px solid #eeeeee;'>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead&nbsp;Id:</strong></td>"
					+ "<td colspan='3' style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadId()+"</td> "
					+ "</tr> "
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Name:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getName()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Email Id:</strong></td>"
					
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getEmail()+"</td></tr>"
					
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Mobile:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getMobile()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Source of Lead:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadSourceFkId().getCompanyName()+"</td></tr>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead Type:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadTypeFkId().getCommonConstantValue()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Region:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16x;'>"+leadManage.getRegionFkId().getRegionName()+"</td></tr>"
					+ "</table></td></tr></tbody></td></tr></table>";
			
			String body3="<br><br> For more detail kindly visit to the portal. <br>"
					 +"URL: http://worksmart.jindalpanther.com/LeadMkt/login<br><br><br> Thanks,<br> TEAM JSPL";						
			String body=body1+body4+body3;
			System.out.println(body);
			/*List<String> toUser=new ArrayList<String>();
		//	toUser.add("kundan.kumar@jindalsteel.com");
			toUser.add(param.getRmEmail());*/
			User currentUser=user.getUserDetail();
			List<String> toUser=new ArrayList<String>();
			toUser.add("kundan.kumar@jindalsteel.com");
			String fromUser=currentUser.getEmail();
			ResourceBundle bundle=ResourceBundle.getBundle("mail");
			List<String> bccUser=new ArrayList<String>();			
			String[] bccUserArr=bundle.getString("bcc.user").split(",");
			for (String bccUsr : bccUserArr) {
				bccUser.add(bccUsr);
			}
			//bccUser.add(bundle.getString("bcc.user"));
			System.out.println(bundle.getString("bcc.user")+"----------------------------FROM USER");
			//String fromUser=bundle.getString("from.user");
			List<String> ccUser=new ArrayList<String>();
			
		//	String[] ccUserArr=bundle.getString("cc.user").split(",");
			
			//ccUser.add(bundle.getString("cc.user"));
		//	System.out.println(ccUser+"----------------------------FROM USER");
			MailUtil.sendMail(fromUser, toUser, ccUser, bccUser, subject, body, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void sendMailToAssignLeadToStockyard(LeadManage leadManage) {
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			EmailDto param=new EmailDto();
			param.setDistFkId(leadManage.getLeadManagePkId());
			param=mailAlertDao.getEmailForRSM(param);
			String subject = "Lead cancelled | Lead NO: "+leadManage.getLeadId();
			String body1="Dear Team,  <br><br>This is for your information that a Lead assigned by you, raised on date "+DateUtility.dateToString(new Date())+". Below the details of the Lead.<br><br>";
			String body4="<table cellpadding='0' cellspacing='0' style=' min-height:500px; padding:2%; width:650px;'><tr><td><tbody>"
					+ "<tr><td><table width='100%' cellpadding='5' cellspacing='0' border='0' style='border:1px solid #eeeeee;'>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead&nbsp;Id:</strong></td>"
					+ "<td colspan='3' style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadId()+"</td> "
					+ "</tr> "
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Name:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getName()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Email Id:</strong></td>"
					
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getEmail()+"</td></tr>"
					
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Mobile:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getMobile()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Source of Lead:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadSourceFkId().getCompanyName()+"</td></tr>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead Type:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadTypeFkId().getCommonConstantValue()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Region:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16x;'>"+leadManage.getRegionFkId().getRegionName()+"</td></tr>"
					+ "</table></td></tr></tbody></td></tr></table>";
			
			String body3="<br><br> For more detail kindly visit to the portal. <br>"
					 +"URL: http://worksmart.jindalpanther.com/LeadMkt/login<br><br><br> Thanks,<br> TEAM JSPL";						
			String body=body1+body4+body3;
			System.out.println(body);
			/*List<String> toUser=new ArrayList<String>();
		//	toUser.add("kundan.kumar@jindalsteel.com");
			toUser.add(param.getRmEmail());*/
			User currentUser=user.getUserDetail();
			List<String> toUser=new ArrayList<String>();
			toUser.add(leadManage.getStockyardAssignFkId().getEmail());
			String fromUser=currentUser.getEmail();
			ResourceBundle bundle=ResourceBundle.getBundle("mail");
			List<String> bccUser=new ArrayList<String>();			
			String[] bccUserArr=bundle.getString("bcc.user").split(",");
			for (String bccUsr : bccUserArr) {
				bccUser.add(bccUsr);
			}
			//bccUser.add(bundle.getString("bcc.user"));
			System.out.println(bundle.getString("bcc.user")+"----------------------------FROM USER");
			//String fromUser=bundle.getString("from.user");
			List<String> ccUser=new ArrayList<String>();
			
		//	String[] ccUserArr=bundle.getString("cc.user").split(",");
			
			//ccUser.add(bundle.getString("cc.user"));
		//	System.out.println(ccUser+"----------------------------FROM USER");
			MailUtil.sendMail(fromUser, toUser, ccUser, bccUser, subject, body, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void sendMailToAssignLeadToRsmBulkUpload(LeadManage leadManage) {
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			EmailDto param=new EmailDto();
			param.setDistFkId(leadManage.getLeadManagePkId());
			param=mailAlertDao.getEmailForRSM(param);
			String subject = "Lead Assign | Lead NO: "+leadManage.getLeadId();
			List<LeadMaterialMap> leadMaterialMapList=leadManage.getLeadMaterialMaps();
			String body1="Dear Team,  <br><br>This is for your information that a Lead assigned by you, raised on date "+DateUtility.dateToString(new Date())+". Below the details of the Lead.<br><br>";
			String body4="<table cellpadding='0' cellspacing='0' style=' min-height:500px; padding:2%; width:650px;'><tr><td><tbody>"
					+ "<tr><td><table width='100%' cellpadding='5' cellspacing='0' border='0' style='border:1px solid #eeeeee;'>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead&nbsp;Id:</strong></td>"
					+ "<td colspan='3' style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadId()+"</td> "
					+ "</tr> "
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Name:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getName()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Email Id:</strong></td>"
					
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getEmail()+"</td></tr>"
					
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Customer&nbsp;Mobile:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getMobile()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Source of Lead:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadSourceFkId().getCompanyName()+"</td></tr>"
					+ "<tr><td style='border:1px solid #eeeeee;'><strong>Lead Type:</strong></td>"
					+ " <td style='border:1px solid #eeeeee; color:#f47920; font-size:16px;'>"+leadManage.getLeadTypeFkId().getCommonConstantValue()+"</td>"
					+ "<td style='border:1px solid #eeeeee;'><strong>Region:</strong></td>"
					+ " <td  style='border:1px solid #eeeeee; color:#f47920; font-size:16x;'>"+leadManage.getRegionFkId().getRegionName()+"</td></tr>"
					+ "</table></td></tr></tbody></td></tr></table>";
			
			String body3="<br><br> For more detail kindly visit to the portal. <br>"
					 +"URL: http://worksmart.jindalpanther.com/LeadMkt/login<br><br><br> Thanks,<br> TEAM JSPL";			
			
			String body=body1+body4+body3;
			System.out.println(body);
			List<String> toUser=new ArrayList<String>();
		//	toUser.add("kundan.kumar@jindalsteel.com");
			toUser.add(leadManage.getRsmAssignFkId().getEmail());
			//ResourceBundle bundle=ResourceBundle.getBundle("mail");
			List<String> bccUser=new ArrayList<String>();
			
			String[] bccUserArr=bundle.getString("bcc.user").split(",");
			for (String bccUsr : bccUserArr) {
				bccUser.add(bccUsr);
			}
			//bccUser.add(bundle.getString("bcc.user"));
			System.out.println(bundle.getString("bcc.user")+"----------------------------FROM USER");
			String fromUser=bundle.getString("from.user");
			List<String> ccUser=new ArrayList<String>();
			
		//	String[] ccUserArr=bundle.getString("cc.user").split(",");
			
			ccUser.add(bundle.getString("cc.user"));
			System.out.println(ccUser+"----------------------------FROM USER");
			MailUtil.sendMail(fromUser, toUser, ccUser, bccUser, subject, body, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}



	/*@Override
	public void sendMailByRsm(List<Leadmanage> leadManageList) {
		try{
		
		User currentUser=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String fromUser=currentUser.getEmail();
	//System.out.println("from;;;;;"+fromUser);
		
		Leadmanage leadManage=leadManageList.get(0);
		int idIndex=0;
		StringBuffer leadId= new StringBuffer();

		for(Leadmanage leadManageFromList :leadManageList){
			leadId.append(leadManageFromList.getLeadId());
			idIndex++;
			if(idIndex <leadManageList.size()){
				leadId.append(", ");
			}
		}


		User user=leadManage.getLeadRsmAssignedFkId();
		
		String toUser=user.getEmail();
		//String toUser=hod.getEmail();
		System.out.println("toMail1234"+toUser);
		String subject="Lead have been Assigned";
		String body="Dear "+user.getName()+"<br>"
		+"On equiring leads with leadId "+leadId.toString() +" Please check,validate and update the enquiry<br>"
		+"Try to convert lead to sale<br>"
		+"Regards<br>"
		+currentUser.getName();
		
		//String[] ccUser={"deepak.singh@jindalsteel.com","rishabh.gupta@jindalsteel.com","prankur.bhatnagar@jindalsteel.com"};
		//mailUtil.sendMail(fromUser, toMail, subject, body);
		mailUtil.sendMail(fromUser,toUser, subject, body);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}*/


}
