package com.jspl.lms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.tool.xml.css.parser.State;
import com.jspl.lms.dao.CommonDao;
import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.ReportingDto;
import com.jspl.lms.model.User;
import com.jspl.lms.util.CommonQueryUtil;
@Repository
public class CommonDaoImpl implements CommonDao{
	
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<State> getStateList() {

		return sessionFactory.getCurrentSession().createQuery(CommonQueryUtil.GET_STATE_LIST.toString()).list();
	}
	@Override
	public Integer getDistributorFkId(Integer userPkId) {
				return (Integer) sessionFactory.getCurrentSession().
						createSQLQuery("SELECT d.distributor_pk_id FROM distributor d WHERE d.user_fk_id=:userPkId ").setParameter("userPkId",userPkId).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CommonConstant> getDataFromCommonConstant(String code) {
		return sessionFactory.getCurrentSession().createQuery("From CommonConstant where commonConstantName =:code and status=true")
				.setParameter("code", code).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(CommonQueryUtil.GET_COUNTRY_LIST.toString()).list();
	}
	@Override
	public List<User> getSOList() {
		return sessionFactory.getCurrentSession().createSQLQuery(CommonQueryUtil.GET_SO_LIST.toString()).setResultTransformer(Transformers.aliasToBean(User.class)).list();
	}
	
	@Override
	public List<User> getRMList() {
		return sessionFactory.getCurrentSession().createSQLQuery(CommonQueryUtil.GET_RM_LIST.toString()).setResultTransformer(Transformers.aliasToBean(User.class)).list();
	}
	@Override
	public LeadSource editSaveLeadSource(LeadSource leadSource) {
		 sessionFactory.getCurrentSession().saveOrUpdate(leadSource);
		 return leadSource;	
	}
	@Override
	public List<LeadSource> getLeadSourceList(String roleName) {
		if(roleName=="ADMIN")
		{
			return sessionFactory.getCurrentSession().createQuery("From LeadSource ls where status =true order by ls.leadSourcePkId desc ").list();
		}
		else if(roleName=="EXECUTIVE"){
			return sessionFactory.getCurrentSession().createQuery("SELECT ls.companyName as companyName,ls.leadSourcePkId as leadSourcePkId From LeadSource ls where status =true and ls.leadSourceStatusFkId.commonConstantPkId='16' order by ls.leadSourcePkId").setResultTransformer(Transformers.aliasToBean(LeadSource.class)).list();
		}
		else{
			return sessionFactory.getCurrentSession().createQuery("From LeadSource ls where status =true order by ls.leadSourcePkId desc ").list();
		}
		
	}
	
	
	@Override
	public boolean deleteLeadSource(Integer leadSourcePkId) {

		Session session = sessionFactory.getCurrentSession();
		Boolean flag = false;
		int count = 0;
		count = session.createQuery("update LeadSource ls  set ls.status=false  where ls.leadSourcePkId =:leadSourcePkId")
				.setParameter("leadSourcePkId", leadSourcePkId)
				.executeUpdate();
		if(count == 1){
			flag = true;
		}
		return flag;
	}

@Override
public List<LeadManage> getLeadCountList(String roleName, Integer userId) {
	
	Session session = sessionFactory.getCurrentSession();
	String sql=null;
	List<LeadManage> list=null;
	
	if(roleName.equals("ADMIN")){
		sql="SELECT COUNT(lm.lead_manage_pk_id) as totalLead FROM lead_manage lm where lm.lead_status!='26' "
				+ " UNION ALL SELECT COUNT(lm1.lead_manage_pk_id) AS totalLead FROM lead_manage lm1 LEFT JOIN common_constant cc1 ON cc1.common_constant_pk_id=lm1.lead_status "
				+ " WHERE cc1.common_constant_pk_id='22' "
				+ " UNION ALL SELECT COUNT(lm2.lead_manage_pk_id) AS totalLead FROM lead_manage lm2 LEFT JOIN common_constant cc2 ON cc2.common_constant_pk_id=lm2.lead_status "
				+ " WHERE cc2.common_constant_pk_id='23' "
				+ " UNION ALL SELECT COUNT(lm3.lead_manage_pk_id) AS totalLead FROM lead_manage lm3 LEFT JOIN common_constant cc3 ON cc3.common_constant_pk_id=lm3.lead_type_fk_id "
				+ " where cc3.common_constant_name='LEAD_TYPE' and cc3.common_constant_value='RETAIL' and lm3.lead_status!='26'"
				+ " UNION ALL SELECT COUNT(lm4.lead_manage_pk_id) AS totalLead "
				+ " FROM lead_manage lm4 LEFT JOIN common_constant cc4 ON cc4.common_constant_pk_id=lm4.lead_type_fk_id"
				+ " where cc4.common_constant_name='LEAD_TYPE' and cc4.common_constant_value='PROJECT' and lm4.lead_status!='26' "
				+ " UNION ALL SELECT COUNT(lm5.lead_manage_pk_id) AS totalLead FROM lead_manage lm5 "
				+ " LEFT JOIN common_constant cc5 ON cc5.common_constant_pk_id=lm5.lead_status WHERE  cc5.common_constant_pk_id='24' "
				+ " UNION ALL SELECT COUNT(lm6.lead_manage_pk_id) AS totalLead FROM lead_manage lm6 "
				+ " LEFT JOIN common_constant cc6 ON cc6.common_constant_pk_id=lm6.lead_status WHERE  cc6.common_constant_pk_id='25' "
				+ " UNION ALL SELECT COUNT(lm7.lead_manage_pk_id) AS totalLead FROM lead_manage lm7 "
				+ " LEFT JOIN common_constant cc7 ON cc7.common_constant_pk_id=lm7.lead_status WHERE  cc7.common_constant_pk_id='28' ";
	}else if(roleName.equals("REGIONAL_MANAGER")){
		sql="SELECT COUNT(lm.lead_manage_pk_id) as totalLead FROM lead_manage lm WHERE lm.lead_status NOT IN ('26','28','23') and lm.rsm_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm1.lead_manage_pk_id) AS totalLead FROM lead_manage lm1 LEFT JOIN common_constant cc1 ON cc1.common_constant_pk_id=lm1.lead_status "
				+ " WHERE cc1.common_constant_pk_id='22' AND lm1.rsm_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm2.lead_manage_pk_id) AS totalLead FROM lead_manage lm2 LEFT JOIN common_constant cc2 ON cc2.common_constant_pk_id=lm2.lead_status "
				+ " WHERE cc2.common_constant_pk_id='23' AND lm2.rsm_assign_fk_id=:userId"
				+ " UNION ALL SELECT COUNT(lm3.lead_manage_pk_id) AS totalLead FROM lead_manage lm3 LEFT JOIN common_constant cc3 ON cc3.common_constant_pk_id=lm3.lead_type_fk_id "
				+ " where cc3.common_constant_name='LEAD_TYPE' and cc3.common_constant_value='RETAIL' and lm3.lead_status NOT IN ('26','28','23') "
				+ "  AND lm3.rsm_assign_fk_id=:userId UNION ALL SELECT COUNT(lm4.lead_manage_pk_id) AS totalLead "
				+ " FROM lead_manage lm4 LEFT JOIN common_constant cc4 ON cc4.common_constant_pk_id=lm4.lead_type_fk_id"
				+ " where cc4.common_constant_name='LEAD_TYPE' and cc4.common_constant_value='PROJECT' and lm4.lead_status NOT IN ('26','28','23') AND lm4.rsm_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm5.lead_manage_pk_id) AS totalLead FROM lead_manage lm5 "
				+ " LEFT JOIN common_constant cc5 ON cc5.common_constant_pk_id=lm5.lead_status WHERE  cc5.common_constant_pk_id='24' AND lm5.rsm_assign_fk_id=:userId " 
				+ " UNION ALL SELECT COUNT(lm6.lead_manage_pk_id) AS totalLead FROM lead_manage lm6 "
				+ " LEFT JOIN common_constant cc6 ON cc6.common_constant_pk_id=lm6.lead_status WHERE  cc6.common_constant_pk_id='25' AND lm6.rsm_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm7.lead_manage_pk_id) AS totalLead FROM lead_manage lm7 "
				+ " LEFT JOIN common_constant cc7 ON cc7.common_constant_pk_id=lm7.lead_status WHERE  cc7.common_constant_pk_id='28' ";
	}else if(roleName.equals("SALES_MARKETING")){
		sql="SELECT COUNT(lm.lead_manage_pk_id) as totalLead FROM lead_manage lm WHERE lm.lead_status NOT IN ('26','28','22') and lm.so_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm1.lead_manage_pk_id) AS totalLead FROM lead_manage lm1 LEFT JOIN common_constant cc1 ON cc1.common_constant_pk_id=lm1.lead_status "
				+ " WHERE cc1.common_constant_pk_id='22' AND lm1.so_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm2.lead_manage_pk_id) AS totalLead FROM lead_manage lm2 LEFT JOIN common_constant cc2 ON cc2.common_constant_pk_id=lm2.lead_status "
				+ " WHERE cc2.common_constant_pk_id='23' AND lm2.so_assign_fk_id=:userId"
				+ " UNION ALL SELECT COUNT(lm3.lead_manage_pk_id) AS totalLead FROM lead_manage lm3 LEFT JOIN common_constant cc3 ON cc3.common_constant_pk_id=lm3.lead_type_fk_id "
				+ " where cc3.common_constant_name='LEAD_TYPE' and cc3.common_constant_value='RETAIL' and lm3.lead_status NOT IN ('26','28','22') "
				+ " AND lm3.so_assign_fk_id=:userId UNION ALL SELECT COUNT(lm4.lead_manage_pk_id) AS totalLead "
				+ " FROM lead_manage lm4 LEFT JOIN common_constant cc4 ON cc4.common_constant_pk_id=lm4.lead_type_fk_id"
				+ " where cc4.common_constant_name='LEAD_TYPE' and cc4.common_constant_value='PROJECT' and lm4.lead_status NOT IN ('26','28','22') AND lm4.so_assign_fk_id=:userId"
				+ " UNION ALL SELECT COUNT(lm5.lead_manage_pk_id) AS totalLead FROM lead_manage lm5 "
				+ " LEFT JOIN common_constant cc5 ON cc5.common_constant_pk_id=lm5.lead_status WHERE  cc5.common_constant_pk_id='24' AND lm5.so_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm6.lead_manage_pk_id) AS totalLead FROM lead_manage lm6 "
				+ " LEFT JOIN common_constant cc6 ON cc6.common_constant_pk_id=lm6.lead_status WHERE  cc6.common_constant_pk_id='25' AND lm6.so_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm7.lead_manage_pk_id) AS totalLead FROM lead_manage lm7 "
				+ " LEFT JOIN common_constant cc7 ON cc7.common_constant_pk_id=lm7.lead_status WHERE  cc7.common_constant_pk_id='28' ";
	}else if(roleName.equals("STOCKYARD_MANAGER")){
		sql="SELECT COUNT(lm.lead_manage_pk_id) as totalLead FROM lead_manage lm WHERE lm.lead_status NOT IN ('26','23','22') and lm.stockyard_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm1.lead_manage_pk_id) AS totalLead FROM lead_manage lm1 LEFT JOIN common_constant cc1 ON cc1.common_constant_pk_id=lm1.lead_status "
				+ " WHERE cc1.common_constant_pk_id='22' AND lm1.stockyard_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm2.lead_manage_pk_id) AS totalLead FROM lead_manage lm2 LEFT JOIN common_constant cc2 ON cc2.common_constant_pk_id=lm2.lead_status "
				+ " WHERE cc2.common_constant_pk_id='23' AND lm2.stockyard_assign_fk_id=:userId"
				+ " UNION ALL SELECT COUNT(lm3.lead_manage_pk_id) AS totalLead FROM lead_manage lm3 LEFT JOIN common_constant cc3 ON cc3.common_constant_pk_id=lm3.lead_type_fk_id "
				+ " where cc3.common_constant_name='LEAD_TYPE' and cc3.common_constant_value='RETAIL' and lm3.lead_status NOT IN ('26','23','22') "
				+ " AND lm3.stockyard_assign_fk_id=:userId UNION ALL SELECT COUNT(lm4.lead_manage_pk_id) AS totalLead "
				+ " FROM lead_manage lm4 LEFT JOIN common_constant cc4 ON cc4.common_constant_pk_id=lm4.lead_type_fk_id"
				+ " where cc4.common_constant_name='LEAD_TYPE' and cc4.common_constant_value='PROJECT' and lm4.lead_status NOT IN ('26','23','22') AND lm4.stockyard_assign_fk_id=:userId"
				+ " UNION ALL SELECT COUNT(lm5.lead_manage_pk_id) AS totalLead FROM lead_manage lm5 "
				+ " LEFT JOIN common_constant cc5 ON cc5.common_constant_pk_id=lm5.lead_status WHERE  cc5.common_constant_pk_id='24' AND lm5.stockyard_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm6.lead_manage_pk_id) AS totalLead FROM lead_manage lm6 "
				+ " LEFT JOIN common_constant cc6 ON cc6.common_constant_pk_id=lm6.lead_status WHERE  cc6.common_constant_pk_id='25' AND lm6.stockyard_assign_fk_id=:userId "
				+ " UNION ALL SELECT COUNT(lm7.lead_manage_pk_id) AS totalLead FROM lead_manage lm7  "
				+ " LEFT JOIN common_constant cc7 ON cc7.common_constant_pk_id=lm7.lead_status WHERE  cc7.common_constant_pk_id='28' AND lm7.stockyard_assign_fk_id=:userId  ";
	}
	
	if(roleName.equals("ADMIN")){
		list=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("REGIONAL_MANAGER")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("SALES_MARKETING")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("STOCKYARD_MANAGER")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}
	return list;
}
@Override
public List<LeadManage> getLeadSourceCount(String roleName, Integer userId) {
	Session session = sessionFactory.getCurrentSession();
	String sql=null;
	List<LeadManage> list=null;
	sql="SELECT distinct COUNT(lm.lead_manage_pk_id) as totalLead,ls.company_name as companyName FROM lead_manage lm "
			+ " left join lead_source ls on ls.lead_source_pk_id=lm.lead_source_fk_id where 1=1  ";
	if(roleName.equals("ADMIN")){
		sql+=" and lm.lead_status!='26' ";
	}else if(roleName.equals("REGIONAL_MANAGER")){
		sql+=" and lm.lead_status NOT IN ('26','28','23') and lm.rsm_assign_fk_id=:userId";
	}else if(roleName.equals("SALES_MARKETING")){
		sql+=" and lm.lead_status NOT IN ('26','28','22') and lm.so_assign_fk_id=:userId";
	}else if(roleName.equals("STOCKYARD_MANAGER")){
		sql+=" and lm.lead_status NOT IN ('26','23','22') and lm.stockyard_assign_fk_id=:userId";
	}
	
	sql+=" group by lm.lead_source_fk_id LIMIT 3 ";
	if(roleName.equals("ADMIN")){
		list=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("REGIONAL_MANAGER")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("SALES_MARKETING")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}else if(roleName.equals("STOCKYARD_MANAGER")){
		list=session.createSQLQuery(sql).setParameter("userId", userId).setResultTransformer(Transformers.aliasToBean(LeadManage.class)).list();
	}
	return list;
}
@Override
public List<CommonConstant> getDataFromCommonConstantAccToStatus(String code) {
	return sessionFactory.getCurrentSession().createQuery("From CommonConstant where commonConstantName =:code and status=false")
			.setParameter("code", code).list();
}
@Override
public List<ReportingDto> getRsmList(Integer regionId) {
	return sessionFactory.getCurrentSession().createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId ,u.name AS name,u.email AS email ,rr.region_name AS region,u.contact_number AS contactNumber FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN region  rr ON ulm.region_fk_id=rr.region_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=4 AND ulm.region_fk_id=:regionId")
			.setParameter("regionId", regionId)
			.setResultTransformer(Transformers.aliasToBean(ReportingDto.class))
			.list();
}
@Override
public List<ReportingDto> getSoList(Integer regionId) {
	return sessionFactory.getCurrentSession().createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId ,u.name AS name,u.email AS email ,rr.region_name AS region,u.contact_number AS contactNumber FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN region  rr ON ulm.region_fk_id=rr.region_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=3 AND ulm.region_fk_id=:regionId")
			.setParameter("regionId", regionId)
			.setResultTransformer(Transformers.aliasToBean(ReportingDto.class))
			.list();
}
@Override
public List<ReportingDto> getStockyardList(Integer regionId) {
	return sessionFactory.getCurrentSession().createSQLQuery("SELECT DISTINCT u.user_pk_id AS userPkId ,u.name AS name,u.email AS email ,rr.region_name AS region,u.contact_number AS contactNumber FROM user u  LEFT JOIN user_location_map ulm ON u.user_pk_id=ulm.user_fk_id LEFT JOIN user_roles urole ON urole.user_fk_id=u.user_pk_id LEFT JOIN region  rr ON ulm.region_fk_id=rr.region_pk_id LEFT JOIN role r ON r.role_pk_id=urole.role_fk_id WHERE urole.role_fk_id=7 AND ulm.region_fk_id=:regionId")
			.setParameter("regionId", regionId)
			.setResultTransformer(Transformers.aliasToBean(ReportingDto.class))
			.list();
}
}

