package com.jspl.lms.util;

public class CommonQueryUtil {
	public static final StringBuffer GET_STATE_LIST = new StringBuffer("From State s order by stateName asc");
	public static final StringBuffer GET_COUNTRY_LIST = new StringBuffer("From Country s order by countryName asc");
	public static final StringBuffer GET_SO_LIST = new StringBuffer(" SELECT u.name as name,u.user_pk_id as userPkId FROM user u LEFT JOIN user_roles ur ON ur.user_fk_id=u.user_pk_id LEFT JOIN role r ON r.role_pk_id = ur.role_fk_id WHERE r.role_code='SALES_MARKETING' ");
	public static final StringBuffer GET_RM_LIST = new StringBuffer(" SELECT u.name as name,u.user_pk_id as userPkId  FROM user u LEFT JOIN user_roles ur ON ur.user_fk_id=u.user_pk_id LEFT JOIN role r ON r.role_pk_id = ur.role_fk_id WHERE r.role_code='REGIONAL_MANAGER' ");
}
