package com.ecommerce.ecommerce.dto;

public class UserDto {
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	private long Mnuber;
	
	public UserDto(String email, String password, String role, String fullname, long Mnuber) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.Mnuber =Mnuber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getMnuber() {
		return Mnuber;
	}

	public void setMnuber(long mnuber) {
		Mnuber = mnuber;
	}
	
	
	
	
	

}
