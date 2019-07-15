package com.jspl.lms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.MailAlertDao;
import com.jspl.lms.dto.EmailDto;
@Repository
public class MailAlertDaoImpl implements MailAlertDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public EmailDto getEmailForRSM(EmailDto param) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(" select u1.email as rmEmail from lead_manage lm INNER JOIN user u1 ON u1.user_pk_id=lm.rsm_assign_fk_id  where lm.lead_manage_pk_id=:leadPkId ")
				.setParameter("leadPkId", param.getDistFkId());
		return (EmailDto) query.setResultTransformer(Transformers.aliasToBean(EmailDto.class)).uniqueResult();
	}
	


}
