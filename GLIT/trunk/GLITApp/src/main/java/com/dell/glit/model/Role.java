/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1859765546207884485L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long roleId;
	@Column
	private String roleName;
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_roles",  
    joinColumns={@JoinColumn(name="role_id", referencedColumnName="roleId")},  
    inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="userId")})  
    private List<User> userList;  
	
	public Role() {
	}
	
	public Role(long roleId, String roleName, List<User> userList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userList = userList;
	}

	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", userList=" + userList + "]";
	}
	
	
}
