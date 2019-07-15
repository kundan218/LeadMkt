package com.jspl.lms.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.ReportDao;

@Repository
public class ReportDaoImpl implements ReportDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
}
