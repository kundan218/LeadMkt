package com.jspl.lms.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.UserDao;
import com.jspl.lms.model.Location;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.Role;
import com.jspl.lms.model.User;




@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


	public User findUserByUserName(String username) {
		User user=null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(" From User where (username=:username or email=:username) and status=0" ).setParameter("username",username).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		List<User> list = sessionFactory.getCurrentSession()
				.createSQLQuery("select user.user_pk_id as userPkId,user.name as name,user.sap_id as sapId,user.status as status,user.registered_date as registeredDate,"
		      + "user.username as username, user.distributor_dms_id as distributorDmsId,"
						+ "user.password as password, " + "user.email as email,"
						+ "user.contact_number as contactNumber,"
						+ "group_concat(loc.location_name separator ',') as locationName,"
						+ "group_concat(reg.region_name separator ',') as regionName,"
						+ "role.role_name as roleName" + ",role.role_pk_id as roleId  "
						+ ",group_concat(loc.location_pk_id separator ',') as locationPkId "
						+ ",group_concat(reg.region_pk_id separator ',') as regionPkId "
						+ "from user "
						+ "left join user_location_map ulm on ulm.user_fk_id=user.user_pk_id "
						+ "left join location loc on loc.location_pk_id =ulm.location_fk_id "
                        + "left join region reg on reg.region_pk_id =ulm.region_fk_id "
						+ "left join user_roles urole on urole.user_fk_id=user.user_pk_id "
						+ "left join role on role.role_pk_id=urole.role_fk_id"
						+ " group by user.user_pk_id ")
				.addScalar("userPkId", IntegerType.INSTANCE)
				.addScalar("username", StringType.INSTANCE)
				.addScalar("name", StringType.INSTANCE)
				.addScalar("email", StringType.INSTANCE)
				.addScalar("password", StringType.INSTANCE)
				.addScalar("contactNumber", StringType.INSTANCE)
				.addScalar("locationName", StringType.INSTANCE)
				.addScalar("roleName", StringType.INSTANCE)
				.addScalar("roleId", IntegerType.INSTANCE)
				.addScalar("locationPkId", StringType.INSTANCE)
				.addScalar("regionName", StringType.INSTANCE)
				.addScalar("sapId", StringType.INSTANCE)
				.addScalar("distributorDmsId", StringType.INSTANCE)
				.addScalar("regionPkId", IntegerType.INSTANCE)
				.addScalar("status", IntegerType.INSTANCE)
				.addScalar("registeredDate", DateType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(User.class)).list();
		return list;
	}
	
	public List<Location> getLocationList() {
		List<Location> list = sessionFactory.getCurrentSession().createQuery("from Location ").list();
		return list;
	}

	

	public List<Role> getRoleList() {
		List<Role> list = sessionFactory.getCurrentSession().createQuery("from Role ").list();
		return list;
	}

	
	public List<Region> getRegionList() {
		// TODO Auto-generated method stub
		List<Region> list = sessionFactory.getCurrentSession().createQuery("from Region ").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocationListByRegionId(Integer userRegionId) {
		// TODO Auto-generated method stub
		List<Location> list = sessionFactory.getCurrentSession()
				.createSQLQuery("select loc.location_pk_id as locationPkId,loc.location_name as locationName"
					     
									+ " from location loc "
									+ " left join region_location_map rlm on rlm.location_fk_id=loc.location_pk_id "
									
									+ " where rlm.region_fk_id=:userRegionId")
				              
									
							.addScalar("locationName", StringType.INSTANCE)
							
							.addScalar("locationPkId", IntegerType.INSTANCE)
							.setParameter("userRegionId", userRegionId)
							.setResultTransformer(Transformers.aliasToBean(Location.class)).list();
					return list;
		
	}

	public int forgetPassword(String encPassword, String userId) {
		String hql=" update user set password=:password where email=:username ";
		int rowAffeted=sessionFactory.getCurrentSession().createSQLQuery(hql).setParameter("password", encPassword).setParameter("username", userId).executeUpdate();
		return rowAffeted;
	}

	@Override
	public void changePassword(String encPassword, String usernmae) {
		// TODO Auto-generated method stub
		String hql=" update user set password=:password where email=:username or username=:username ";
	sessionFactory.getCurrentSession().createSQLQuery(hql).setParameter("password", encPassword).setParameter("username", usernmae).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListByRole(String role) {
		Session session=sessionFactory.getCurrentSession();
		List<User> users=null;
		users=session.createSQLQuery("SELECT u.email as email ,u.user_pk_id as userPkId  FROM user u LEFT JOIN user_roles ur ON u.user_pk_id=ur.user_fk_id LEFT JOIN role r ON r.role_pk_id=ur.role_fk_id "
				+ "where r.role_name=:role")
		.setParameter("role", role)
		.setResultTransformer(Transformers.aliasToBean(User.class)).list();
		return users;

	}


}
