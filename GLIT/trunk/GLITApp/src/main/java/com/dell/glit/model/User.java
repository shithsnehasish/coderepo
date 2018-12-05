/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author SNEHASISH_SHITH
 * 
 */
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209226504978093002L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment")
	private long userId;
	@Column(unique=true, nullable=false)
	private String name;
	@Column
	private String password;
	@Column
	private boolean enabled;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "userId") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "roleId") })
	private Role role;
	@OneToMany(mappedBy="user")
	private Set<Questionaire> questionnaires;

	public User() {
	}

	public User(long userId, String name, String password, boolean enabled,
			Role role, Set<Questionaire> questionnaires) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.questionnaires = questionnaires;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password="
				+ password + ", enabled=" + enabled + ", role=" + role
				+ ", questionnaires=" + questionnaires + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Questionaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<Questionaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
}
