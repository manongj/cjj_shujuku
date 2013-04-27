package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * 成员信息
 * */
@Entity(name="cjj_user")
public class User extends GenericModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="u_id")
	private int id;
	
	/** 用户帐号 */
	@Column(name="account")
	private String account;
	
	/** 用户名 */
	@Column(name="username")
	private String username;
	
	/** 用户密码 */
	@Column(name="password")
	private String password;
	
	/** 登录IP */
	@Column(name="ip")
	private String ip;
	
	/** 登录时间 */
	@Column(name="logintime")
	private Date logintime;
	
	public User(String account, String username) {
		this.account = account;
		this.username = username;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getIp() {
		return ip;
	}
	
	public Date getLogintime() {
		return logintime;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	
}

