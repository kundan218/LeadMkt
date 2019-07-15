package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_pk_id")
	private Integer userRolePkId;

	@Column(name = "role_fk_id", nullable = false)
	private Integer roleId;

	@Column(name = "user_fk_id")
	private Integer userFkId;

	@OneToOne(cascade = { CascadeType.ALL }, targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_fk_id", referencedColumnName = "role_pk_id", insertable = false, updatable = false)
	private Role role;

	public Integer getUserRolePkId() {
		return userRolePkId;
	}

	public void setUserRolePkId(Integer userRolePkId) {
		this.userRolePkId = userRolePkId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserFkId() {
		return userFkId;
	}

	public void setUserFkId(Integer userFkId) {
		this.userFkId = userFkId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
