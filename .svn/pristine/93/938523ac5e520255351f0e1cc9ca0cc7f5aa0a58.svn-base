package com.jspl.lms.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.DashBoardDao;
import com.jspl.lms.dto.DashboardDTO;
import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.model.DataTableDto;
import com.jspl.lms.model.LeadManageDto;
import com.jspl.lms.model.Region;

@Repository
public class DashBoardDaoImpl implements DashBoardDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String getTotalDistributor() {
		BigInteger totalDistributor=null;
		totalDistributor=(BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(distributor_pk_id) FROM distributor WHERE status is true").uniqueResult();
		return totalDistributor+"";
	}

	@Override
	public Long countLeadManageData(DataTableDto dataTableDto, String roleName, Integer userId) {
		Long countData = 0l;
		String hql=null;
		hql="select count(lm.leadManagePkId) from  LeadManage lm where isDeleted=true  ";
		if (dataTableDto != null && dataTableDto.getSearch().getValue()!=null && !dataTableDto.getSearch().getValue().equals("")) {
			hql += "and lm.name  LIKE :search OR lm.leadId LIKE :search OR lm.leadStatus.commonConstantValue LIKE :search OR lm.leadSourceFkId.companyName LIKE :search  ";
		}
		if(roleName.equals("ADMIN")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('22','23','24','25','27','28') ";
		}
		else if(roleName.equals("REGIONAL_MANAGER")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('22','23','24','25','27','28') and lm.rsmAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("SALES_MARKETING")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('23','24','25','27','28') and  lm.soAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("STOCKYARD_MANAGER")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('23','24','25','27','28') and  lm.stockyardAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("EXECUTIVE")){
			hql+= " and lm.createdBy.userPkId=:userId  ";
		}

		hql+=" order by lm.leadManagePkId desc ";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
	
	if(roleName.equals("ADMIN")){
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
			countData = (Long) query.uniqueResult();
		}
	else if(roleName.equals("REGIONAL_MANAGER")){
		if(userId!=null){
			query.setParameter("userId", userId);
		}
		
		if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
			query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
		}
		countData = (Long) query.uniqueResult();
	}
	else if(roleName.equals("SALES_MARKETING")){
		if(userId!=null){
			query.setParameter("userId", userId);
		}
		
		if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
			query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
		}
		countData = (Long) query.uniqueResult();
	}
	else if(roleName.equals("EXECUTIVE")){
		if(userId!=null){
			query.setParameter("userId", userId);
		}
		
		if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
			query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
		}
		countData = (Long) query.uniqueResult();
	}
	else if(roleName.equals("STOCKYARD_MANAGER")){
		if(userId!=null){
			query.setParameter("userId", userId);
		}
		
		if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
			query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
		}
		countData = (Long) query.uniqueResult();
	}
	
		else{
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
			countData = (Long) query.uniqueResult();
		}
	System.out.println("data1234"+countData);
		return countData;
	}

	@Override
	public List<LeadManageDto> getLeadManageList(DataTableDto dataTableDto, String roleName, Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		List<LeadManageDto> leadManageDtoList = null;
		String hql=null;
		hql="select lm.name as name,lm.leadManagePkId as leadManagePkId ,lm.leadSourceFkId as leadSourceFkId,lm.createdDate as "
				+ "createdDate,lm.leadId as leadId,lm.leadStatus as leadStatus ,lm.rsmAssignFkId as rsmAssignFkId, "
				+" lm.leadSourceFkId as leadSourceFkId ,lm.regionFkId as regionFkId ,lm.amount as amount,lm.createdBy as createdBy  "		
				+ ",lm.soAssignFkId as soAssignFkId "
				+ ",lm.stockyardAssignFkId as stockyardAssignFkId,  "
				+ " lm.cancelledBy as cancelledBy,lm.convertedToSaleBy as convertedToSaleBy "
				+ "from  LeadManage lm LEFT JOIN lm.rsmAssignFkId LEFT JOIN lm.soAssignFkId LEFT JOIN lm.stockyardAssignFkId "
				+ " LEFT JOIN lm.cancelledBy LEFT JOIN lm.convertedToSaleBy "
				+ "where lm.isDeleted=true  ";
		if (dataTableDto != null && dataTableDto.getSearch().getValue()!=null && !dataTableDto.getSearch().getValue().equals("")) {
			hql += "and lm.name  LIKE :search  OR lm.leadId  LIKE :search OR lm.leadStatus.commonConstantValue LIKE :search OR lm.leadSourceFkId.companyName LIKE :search  ";
		}
		if(roleName.equals("ADMIN")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('22','23','24','25','27','28') ";
		}
		else if(roleName.equals("REGIONAL_MANAGER")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('22','23','24','25','27','28') and  lm.rsmAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("SALES_MARKETING")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('23','24','25','27','28')  and lm.soAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("STOCKYARD_MANAGER")){
			hql+= " and lm.leadStatus.commonConstantPkId in ('23','24','25','27','28') and  lm.stockyardAssignFkId.userPkId=:userId  ";
		}
		else if(roleName.equals("EXECUTIVE")){
			hql+= " and lm.createdBy.userPkId=:userId  ";
		}

		hql+=" order by lm.leadManagePkId desc ";
		Query query=session.createQuery(hql);
		if(dataTableDto.getStart() != null){
			query.setFirstResult(dataTableDto.getStart());
			query.setMaxResults(dataTableDto.getLength());
		}
		if(roleName.equals("ADMIN")){
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){

				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}

		}
		else if(roleName.equals("REGIONAL_MANAGER")){
			if(userId!=null){
				query.setParameter("userId", userId);
			}
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
		}
		else if(roleName.equals("SALES_MARKETING")){
			if(userId!=null){
				query.setParameter("userId", userId);
			}
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
		}
		else if(roleName.equals("STOCKYARD_MANAGER")){
			if(userId!=null){
				query.setParameter("userId", userId);
			}
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
		}
		
		else if(roleName.equals("EXECUTIVE")){
			if(userId!=null){
				query.setParameter("userId", userId);
			}
			
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){
				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
		}

		else{
			if(dataTableDto.getSearch().getValue() !=null && !dataTableDto.getSearch().getValue().equals("")){

				query.setParameter("search","%"+dataTableDto.getSearch().getValue()+"%");
			}
		}
		
		query.setResultTransformer(Transformers.aliasToBean(LeadManageDto.class));
		return leadManageDtoList=query.list();

	}

	@Override
	public List<Region> getRegionListByUserId(ReportParam param) {
		List<Region> regionList=null;
		Integer userId=null;
		StringBuffer hql= new StringBuffer(" FROM Region ");
		StringBuffer hqlLocation=new StringBuffer (" SELECT r.region_pk_id AS regionPkId,r.region_name AS regionName "
				+ " FROM region r LEFT JOIN user_location_map ulp ON ulp.region_fk_id=r.region_pk_id WHERE 1=1 ");
				 
		System.out.println("User Role Id::::"+param.getRoleId());
		if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			
		}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
			userId=param.getUserPkId();
			hqlLocation.append(" and ulp.user_fk_id=:userId GROUP BY r.region_pk_id ");
		}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
			userId=param.getUserPkId();
			hqlLocation.append(" and ulp.user_fk_id=:userId GROUP BY r.region_pk_id ");
		}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
			userId=param.getUserPkId();
			hqlLocation.append(" and ulp.user_fk_id=:userId  GROUP BY r.region_pk_id");
		}
		if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			regionList=sessionFactory.getCurrentSession().createQuery(hql.toString()).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
			regionList=sessionFactory.getCurrentSession().createSQLQuery(hqlLocation.toString()).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(Region.class)).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
			regionList=sessionFactory.getCurrentSession().createSQLQuery(hqlLocation.toString()).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(Region.class)).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
			regionList=sessionFactory.getCurrentSession().createSQLQuery(hqlLocation.toString()).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(Region.class)).list();
		}
		
		return regionList;
	
	}

	@Override
	public List<DashboardDTO> getSalesReport(ReportParam param) {
		String sql=null;
		Integer userId=null;
		List<DashboardDTO> list=null;
		if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			sql= " SELECT DISTINCT SUM(lmp.quantity) AS sales, lm.region_fk_id AS regionPkId,  "
					+ " DATE(lm.created_date) AS date, DAYNAME(DATE(lm.created_date)) AS dayName  FROM lead_manage lm "
					+ " INNER JOIN lead_material_map lmp ON lmp.lead_manage_fk_id=lm.lead_manage_pk_id "
			/*		+ " LEFT JOIN region_location_map rlm ON rlm.region_fk_id = lm.region_fk_id"
					+ " LEFT JOIN location l ON l.location_pk_id=rlm.location_fk_id "*/
					+ " WHERE lm.lead_status!='26' and lm.created_date >= DATE(NOW()) - INTERVAL 6 DAY"
					+ " ";
		}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
			userId=param.getUserPkId();
			sql= " SELECT DISTINCT SUM(lmp.quantity) AS sales, lm.region_fk_id AS regionPkId,"
				//	+ "rlm.location_fk_id AS locationFkId,  "
					+ " DATE(lm.created_date) AS date, DAYNAME(DATE(lm.created_date)) AS dayName  FROM lead_manage lm "
					+ " INNER JOIN lead_material_map lmp ON lmp.lead_manage_fk_id=lm.lead_manage_pk_id "
				//	+ " LEFT JOIN region_location_map rlm ON rlm.region_fk_id = lm.region_fk_id"
				//	+ " LEFT JOIN location l ON l.location_pk_id=rlm.location_fk_id "
					+ " WHERE lm.lead_status!='26' and lm.created_date >= DATE(NOW()) - INTERVAL 6 DAY"
					+ " ";
			sql+= " and lm.rsm_assign_fk_id=:userId";
		}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
			userId=param.getUserPkId();
			sql= " SELECT DISTINCT SUM(lmp.quantity) AS sales, lm.region_fk_id AS regionPkId,"
				//	+ "rlm.location_fk_id AS locationFkId,  "
					+ " DATE(lm.created_date) AS date, DAYNAME(DATE(lm.created_date)) AS dayName  FROM lead_manage lm "
					+ " INNER JOIN lead_material_map lmp ON lmp.lead_manage_fk_id=lm.lead_manage_pk_id "
				//	+ " LEFT JOIN region_location_map rlm ON rlm.region_fk_id = lm.region_fk_id"
				//	+ " LEFT JOIN location l ON l.location_pk_id=rlm.location_fk_id "
					+ " WHERE lm.lead_status!='26' and lm.created_date >= DATE(NOW()) - INTERVAL 6 DAY"
					+ " ";
			sql+= " and lm.so_assign_fk_id=:userId";
		}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
			userId=param.getUserPkId();
			sql= " SELECT DISTINCT SUM(lmp.quantity) AS sales, lm.region_fk_id AS regionPkId,"
				//	+ "rlm.location_fk_id AS locationFkId,  "
					+ " DATE(lm.created_date) AS date, DAYNAME(DATE(lm.created_date)) AS dayName  FROM lead_manage lm "
					+ " INNER JOIN lead_material_map lmp ON lmp.lead_manage_fk_id=lm.lead_manage_pk_id "
				//	+ " LEFT JOIN region_location_map rlm ON rlm.region_fk_id = lm.region_fk_id"
				//	+ " LEFT JOIN location l ON l.location_pk_id=rlm.location_fk_id "
					+ " WHERE lm.lead_status!='26' and lm.created_date >= DATE(NOW()) - INTERVAL 6 DAY"
					+ " ";
			sql+= " and lm.stockyard_assign_fk_id=:userId";
		}
		sql+="  GROUP BY lm.region_fk_id, DATE(lm.created_date) ORDER BY lm.created_date ASC ";
		if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			list=sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(DashboardDTO.class)).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
			list=sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("userId",userId).setResultTransformer(Transformers.aliasToBean(DashboardDTO.class)).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
			list=sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("userId",userId).setResultTransformer(Transformers.aliasToBean(DashboardDTO.class)).list();
		}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
			list=sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("userId",userId).setResultTransformer(Transformers.aliasToBean(DashboardDTO.class)).list();
		}
		
		
		return list;
	}

	


}