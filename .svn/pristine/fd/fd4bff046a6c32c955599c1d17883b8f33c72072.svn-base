package com.jspl.lms.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.DistributorDao;
import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.model.Distributor;
@Repository
public class DistributorDaoImpl implements DistributorDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Distributor saveDistributor(Distributor distributor) {
  try{
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(distributor);
  }catch(HibernateException he){
	he.printStackTrace();
}
		return distributor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distributor> getDistributorList() {
		return sessionFactory.openSession().createQuery("FROM Distributor WHERE status is true order by distributorPkId ").list();
	}


	@Override
	public boolean deleteDistributor(Integer distributorId) {
		boolean flag = false;
		Session session= sessionFactory.getCurrentSession();
		try{
			Distributor distributor =  (Distributor) session.load(Distributor.class, distributorId);
			if(distributor!=null){
				distributor.setIsDeleted(false);
		    session.update(distributor);
		    flag=true;
			}
		}catch(HibernateException he){
            he.printStackTrace();
            flag = false;
    }
    return flag;
	}

	@Override
	public Distributor findDistributerByUserId(Integer userId) {
		Distributor distributor=null;
		Session session= sessionFactory.getCurrentSession();
		try{
			distributor=(Distributor) session.createQuery("from Distributor d where d.user.userPkId=:userId ")
					.setParameter("userId", userId)
					.setFirstResult(0)
					.setMaxResults(1)
					.uniqueResult();
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return distributor;
	}

	

	@Override
	public List<Distributor> getDistributorByUserId(Integer userPkId,String roleId) {
		StringBuffer hql= new StringBuffer(" FROM Distributor where status is true ");
		
		if(roleId.equals("SALES_MARKETING")){
			hql.append(" and salesOfficer="+userPkId);
		}else if(roleId.equals("REGIONAL_MANAGER")){
			hql.append(" and regionalManager="+userPkId);
		}else if(roleId.equals("ADMIN")){
			
		}else if(roleId.equals("NWM")){
			
		}else if(roleId.equals("STOCKYARD_MANAGER")){
			hql.append(" and stockyardManager="+userPkId);
		}else if(roleId.equals("ZSM")){
			hql.append(" and zsm="+userPkId);
		}
		hql.append(" order by distributorPkId ");
		List<Distributor> distributorList=sessionFactory.getCurrentSession().createQuery(hql.toString()).list();
		return distributorList;
	}

	@Override
	public List<Distributor> getDistributorListByUserId(ReportParam param) {
		System.out.println("Role DAO::::::::::::;"+param.getRoleId());
		StringBuffer hql= new StringBuffer(" FROM Distributor where status is true ");
		System.out.println("User Role Id::::"+param.getRoleId());
		if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			
		}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
			hql.append(" and salesOfficer="+param.getUserPkId()+")");
		}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
			hql.append(" and regionalManager="+param.getUserPkId()+")");
		}
		//For SYM and ZSM roles added on 23-02-2018
		else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
			hql.append(" and stockyardManager="+param.getUserPkId()+")");
		}else if(param.getRoleId()!=null && param.getRoleId().equals("ZSM")){
			hql.append(" and zsm="+param.getUserPkId()+")");
		}else{
			
		}
		hql.append(" order by distributorPkId ");
		List<Distributor> distributorList=sessionFactory.getCurrentSession().createQuery(hql.toString()).list();
		return distributorList;
	}

	
	
	
}