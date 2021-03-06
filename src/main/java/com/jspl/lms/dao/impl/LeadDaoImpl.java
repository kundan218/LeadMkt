package com.jspl.lms.dao.impl;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.dao.LeadDao;
import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadMaterialMap;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.Location;
import com.jspl.lms.model.Material;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.State;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserInfo;
import com.jspl.lms.model.UserLocationMap;
import com.jspl.lms.service.MailAlertService;

@Repository
public class LeadDaoImpl implements LeadDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MailAlertService mailAlertService;


	@Override
	public LeadManage SaveLead(LeadManage leadManage) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();

		if(leadManage.getLeadManagePkId()==null){

			sessionFactory.getCurrentSession().saveOrUpdate(leadManage);

			StringBuilder uniqueId=new StringBuilder();
			uniqueId.append("Panther/");
			uniqueId.append("LID/");
			uniqueId.append(dateFormat.format(date));
			uniqueId.append("/");
			uniqueId.append("00");
			uniqueId.append(leadManage.getLeadManagePkId().toString());
			leadManage.setLeadId(uniqueId.toString());
		}
		else
		{
			sessionFactory.getCurrentSession().saveOrUpdate(leadManage);

		}

		return leadManage;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getCountry() {
		List<Country> country=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			country=session.createQuery("From Country").list();
		}
		catch (HibernateException he) {

			he.printStackTrace();
		}
		return country;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<State> getState() {
		List<State> state=null;
		try
		{
			Session session=sessionFactory.getCurrentSession();
			state=session.createQuery("From State").list();

		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		return state;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getDistrict(Integer stateFkId) {
		List<Location> district=null;
		try
		{
			Session session=sessionFactory.getCurrentSession();
			district=session.createQuery("From Location l where l.state_fk_id=:stateFkId")
					.setParameter("stateFkId",stateFkId).list();

		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		return district;
	}


	@Override
	public List<Region> getRegion() {
		List<Region> region=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			region=session.createQuery("From Region").list();
		}
		catch (HibernateException he) {

			he.printStackTrace();
		}
		return region;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> getMaterial(Integer sbuFkId) {
		List<Material> material=null;
		System.out.println("prankur"+sbuFkId);
		try
		{
			Session session=sessionFactory.getCurrentSession();
			material=session.createQuery("From Material m where m.sbuTypeFkId.commonConstantPkId=:sbuFkId")
					.setParameter("sbuFkId",sbuFkId).list();

		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		return material;
	}


	@Override
	@Transactional
	public Integer getAssignedRsm(Integer regionId) {
		Session session=sessionFactory.getCurrentSession();
		Integer userId=null;
		try{
			userId=(Integer)session.createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=4 AND ulm.region_fk_id=:regionId")
					.setParameter("regionId", regionId)
					.uniqueResult();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		System.out.println(userId);
		return userId; 
	}


	@Override
	public LeadManage getLeadDetails(Integer leadManagePkId) {
		return (LeadManage) sessionFactory.getCurrentSession().createQuery(" FROM  LeadManage  where leadManagePkId=:leadManagePkId " )
				.setParameter("leadManagePkId",leadManagePkId)
				.uniqueResult();						
	}


	@Override
	public void cancelLead(Integer leadManagePkId,Integer status,String comment) {
		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserPkId();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String cancelledDate = dateFormat.format(date);
		sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + status + "', l.comment='" + comment + "',l.comment='" + comment + "',l.cancelledBy='" + userId + "',l.cancelledDate='" + cancelledDate + "'  where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();
	}



	@Override
	public List<Location> getLocationList() {
		List<Location> locationList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User currentUser=user.getUserDetail();
			Integer regionId=null;		
			List<Integer> l = new ArrayList<Integer>();
			for(UserLocationMap ulm:currentUser.getLocationList()){
				l.add(ulm.getRegionFkId());
			}
			regionId=l.get(0);
			locationList=session.createSQLQuery("SELECT l.location_pk_id as locationPkId,l.location_name AS locationName FROM  location l INNER JOIN region_location_map rlm ON l.location_pk_id=rlm.location_fk_id WHERE rlm.region_fk_id=:regionId")
					.setParameter("regionId", regionId)
					.setResultTransformer(Transformers.aliasToBean(Location.class))
					.list();
		}
		catch(Exception e){
			e.printStackTrace();		
		}
		return locationList;
	}


	@Override
	public List<User> getSmList() {
		List<User> smList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User currentUser=user.getUserDetail();
			Integer regionId=null;		
			List<Integer> l = new ArrayList<Integer>();
			for(UserLocationMap ulm:currentUser.getLocationList()){
				l.add(ulm.getRegionFkId());
			}
			regionId=l.get(0);
			smList=session.createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId ,u.name AS name,u.email as email FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=3 AND ulm.region_fk_id=:regionId")
					.setParameter("regionId", regionId)
					.setResultTransformer(Transformers.aliasToBean(User.class))
					.list();
		}
		catch(Exception e){
			e.printStackTrace();		
		}
		return smList;

	}


	@Override
	public void assignLeadByRsm(Integer leadManagePkId, Integer status, Integer userPkId,String roleList) {		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date soDate = new Date();
		String so_Date = dateFormat.format(soDate);


		if(roleList.equals("STOCKYARD_MANAGER")){
			sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + status + "', l.stockyardAssignFkId='" + userPkId + "',l.stockyardAssignDate='" + so_Date + "' where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();	
		}
		else if(roleList.equals("SALES_MARKETING")){
			sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + status + "', l.soAssignFkId='" + userPkId + "',l.soAssignDate='" + so_Date + "' where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();	
		}
	}

	@Override
	public void assignLeadActionByRsm(Integer leadManagePkId, Integer action, String comment) {
		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserPkId();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String convertToSaleDate = dateFormat.format(date);
		if(action==25){		
			sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + action + "', l.actionCommnet='" + comment + "',l.convertedToSaleBy='" + userId + "',l.convertedToSaleDate='" + convertToSaleDate + "' where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();	
		}
		else{
			sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + action + "', l.actionCommnet='" + comment + "' where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();	
		}

	}


	@Override
	public List<User> getStockyardList() {
		List<User> stockyardList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User currentUser=user.getUserDetail();
			Integer regionId=null;

			List<Integer> l = new ArrayList<Integer>();
			for(UserLocationMap ulm:currentUser.getLocationList()){
				l.add(ulm.getRegionFkId());
			}
			regionId=l.get(0);
			stockyardList=session.createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId ,u.name AS name,u.email as email FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=7 AND ulm.region_fk_id=:regionId")
					.setParameter("regionId", regionId)
					.setResultTransformer(Transformers.aliasToBean(User.class))
					.list();
		}
		catch(Exception e){
			e.printStackTrace();		
		}
		return stockyardList;
	}


	@Override
	public void assignLeadActionBySales(Integer leadManagePkId, Integer smPkId,Integer status) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date soDate = new Date();
		String so_Date = dateFormat.format(soDate);
		sessionFactory.getCurrentSession().createQuery("update LeadManage l set l.leadStatus ='" + status + "', l.stockyardAssignFkId='" + smPkId + "',l.stockyardAssignDate='" + so_Date + "' where l.leadManagePkId =" + leadManagePkId + "").executeUpdate();	

	}


	@Override
	@Transactional
	public Integer getCommonConstantValue(String commonConstantValue) {
		Session session=sessionFactory.getCurrentSession();
		Integer commonConstantPkId=null;
		try{
			commonConstantPkId=(Integer)session.createSQLQuery("SELECT DISTINCT cc.common_constant_pk_id AS commonConstantPkId FROM common_constant cc   WHERE cc.common_constant_value=:commonConstantValue")
					.setParameter("commonConstantValue", commonConstantValue)
					.uniqueResult();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}

		return commonConstantPkId;

	}


	@Override
	@Transactional
	public void saveBulkUploadLead(Date createdDate, String customerName, String leadSource, String leadType,String sbu, String email, String region, String street, String city, String state, String country,String mobile, List<LeadMaterialMap> leadMaterialMapList) {
		Session session=null;
		Transaction transaction = null;
		Integer leadTypeId=null;
		Integer sbuId=null;
		Integer leadSourceId=null;
		Integer regionId=null;
		Integer rsmId=null;
		Integer countryId=null;
		Integer stateId=null;
		CommonConstant leadTypeObj=new CommonConstant();
		CommonConstant sbuTypeObj=new CommonConstant();
		CommonConstant leadStatusObj=new CommonConstant();
		LeadSource leadSourceObj=new LeadSource();
		LeadManage leadManage=new LeadManage();	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		Region regionObj=new Region();
		Country countryObj = new Country();
		State stateObj= new State();
		try{
			session=sessionFactory.openSession();
			BigDecimal totalQuantity=BigDecimal.ZERO;
			transaction = session.beginTransaction();
			leadTypeId=	getCommonConstantValue(leadType);
			sbuId = getCommonConstantValue(sbu);
			leadTypeObj.setCommonConstantPkId(leadTypeId);
			leadManage.setLeadTypeFkId(leadTypeObj);
			sbuTypeObj.setCommonConstantPkId(sbuId);
			leadManage.setSbuFkId(sbuTypeObj);
			
			leadSourceId=(Integer)session.createSQLQuery("SELECT DISTINCT ls.lead_source_pk_id AS leadSourcePkId FROM lead_source ls  WHERE ls.status=true and  ls.company_name=:leadSource")
					.setParameter("leadSource", leadSource)
					.uniqueResult();			
			regionId=(Integer)session.createSQLQuery("SELECT DISTINCT r.region_pk_id AS regionPkId FROM region r  WHERE   r.region_name=:region")
					.setParameter("region", region)
					.uniqueResult();
			countryId=(Integer)session.createSQLQuery("SELECT DISTINCT c.country_pk_id AS countryPkId FROM country c  WHERE   c.country_name=:country")
					.setParameter("country", country)
					.uniqueResult();
			stateId=(Integer)session.createSQLQuery("SELECT DISTINCT state_pk_id AS countryPkId FROM state   WHERE  state_name LIKE :state")
					.setParameter("state", "%"+state+"%")
					.uniqueResult();
			//System.out.println("stateId"+stateId+"countryId"+countryId);
			countryObj.setCountryPkId(countryId);
			stateObj.setStatePkId(stateId);
			regionObj.setRegionPkId(regionId);
			leadSourceObj.setLeadSourcePkId(leadSourceId);
			leadManage.setLeadSourceFkId(leadSourceObj);
			leadManage.setDeleted(true);
			leadManage.setCreatedDate(createdDate);
			leadManage.setHouseNo(street);
			leadManage.setLocation(city);
			leadManage.setEmail(email);
			leadManage.setCountryFkId(countryObj);
     		leadManage.setStateFkId(stateObj);		
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Integer userId=user.getUserPkId();
			User currentUser =new User();
			currentUser.setUserPkId(userId);
			leadManage.setCreatedBy(currentUser);
			leadStatusObj.setCommonConstantPkId(22);
			leadManage.setLeadStatus(leadStatusObj);
			leadManage.setName(customerName);
			rsmId=getAssignedRsm(regionId);
			User rsm=new User();
			rsm.setUserPkId(rsmId);
			leadManage.setRsmAssignFkId(rsm);
			leadManage.setRsmAssignDate(date);
			leadManage.setRegionFkId(regionObj);
			leadManage.setLeadMaterialMaps(leadMaterialMapList);
			leadManage.setMobile(mobile);
			for(LeadMaterialMap leadMaterialMap:leadMaterialMapList){
				totalQuantity=totalQuantity.add(leadMaterialMap.getQuantity());
			}			
			leadManage.setTotalQuantity(totalQuantity);	
			if(leadSourceId!=null && regionId!=null&&leadTypeId!=null&&rsmId!=null&&countryId!=null&&stateId!=null){
				session.saveOrUpdate(leadManage);
				StringBuilder uniqueId=new StringBuilder();
				uniqueId.append("Panther/");
				uniqueId.append("LID/");
				uniqueId.append(dateFormat.format(date));
				uniqueId.append("/");
				uniqueId.append("00");
				uniqueId.append(leadManage.getLeadManagePkId().toString());
				leadManage.setLeadId(uniqueId.toString());
				session.saveOrUpdate(leadManage);
				mailAlertService.sendMailToAssignLeadToRsmBulkUpload(leadManage);
			}
			transaction.commit();
		}
		catch(Exception he){
			he.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
	}

}










