package com.msk.photoapi.users.ms.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserReqModel {
	@NotNull(message = "First name cant be null")
	@Size(min = 2, message = "First Name can not be less than 2 chars")
	private String firstName;
	@NotNull(message = "Last name cant be null")
	@Size(min = 2, message = " Last name can not be less than 2 chars")
	private String lastName;
	@NotNull(message = "Password can not be blank")
	@Size(min = 4, max = 8, message = "Password sould be in betwwen 4 to 8 chars")
	private String password;
	@NotNull(message = "Email can not be blank")
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
