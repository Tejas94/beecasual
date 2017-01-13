package com.ecomm.beecasual.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserRole implements Serializable {
	@Id
	private int userId;
	private int roleId;
	
	
	@OneToOne
	@JoinColumn(name="userId", nullable=false, insertable=false, updatable=false)
	private User user;

	@OneToOne
	@JoinColumn(name="roleId", nullable=false, insertable=false, updatable=false)
	private Role role;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
