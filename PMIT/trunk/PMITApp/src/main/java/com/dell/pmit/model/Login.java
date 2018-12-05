package com.dell.pmit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
	private Long loginId;
	@Column(name = "userName" ,unique=true ,nullable = false, length = 50)
	private String userName;
	@Column(name = "password", nullable = false, length = 500)
	private String password;
	
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	public Login(Long loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}
	
	public Login() {
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
