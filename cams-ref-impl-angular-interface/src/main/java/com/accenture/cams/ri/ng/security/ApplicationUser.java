package com.accenture.cams.ri.ng.security;

public class ApplicationUser extends IdentityUser {

	private String signon;
	private String password;
	private boolean isNotLogged;
	private boolean isAdmin;

	public ApplicationUser() {
		super();
	}

	public String getSignon() {
		return signon;
	}

	public void setSignon(String signon) {
		this.signon = signon;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsNotLogged() {
		return isNotLogged;
	}

	public void setIsNotLogged(boolean isNotLogged) {
		this.isNotLogged = isNotLogged;
	}

	public boolean isIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
