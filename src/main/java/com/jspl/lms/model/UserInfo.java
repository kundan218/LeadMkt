package com.jspl.lms.model;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.User;

public class UserInfo extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final Integer userPkId;
	private final String name;
	private final String sapId;

/*	private List<UserLocationMap> locationList;*/
	
	//private final String distributorId;
	private com.jspl.lms.model.User userDetail;
	
	@SuppressWarnings("unchecked")
	public UserInfo(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,Collection authorities, Integer userPkId, String name,String sapId, com.jspl.lms.model.User userDetail ) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,accountNonLocked, authorities);
		this.userPkId=userPkId;
		this.name=name;
		this.userDetail=userDetail;
		this.sapId=sapId;
	}

	public Integer getUserPkId() {
		return userPkId;
	}

	public String getName() {
		return name;
	}

	public com.jspl.lms.model.User getUserDetail() {
		return userDetail;
	}

	public String getSapId() {
		return sapId;
	}


	public void setUserDetail(com.jspl.lms.model.User userDetail) {
		this.userDetail = userDetail;
	}

	

	

	

	
	
	
	

}
