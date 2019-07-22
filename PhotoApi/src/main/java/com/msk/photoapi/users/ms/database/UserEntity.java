package com.msk.photoapi.users.ms.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Indicates the this class represents the table in db.
@Entity
@Table(name = "PhotoUsers")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8284085756742415982L;
	// Data Base generated ID.
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false, length = 120, unique = false)
	private String email;
	
	@Column(nullable = false, unique = false)
	private String userId;
	
	@Column(nullable = false, unique = false)
	private String encryptedPwd;
	
	@Column(nullable = false, length = 50)
	private String firstName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPwd() {
		return encryptedPwd;
	}

	public void setEncryptedPwd(String encryptedPwd) {
		this.encryptedPwd = encryptedPwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
