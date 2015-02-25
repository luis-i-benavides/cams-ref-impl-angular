package com.accenture.cams.ri.ng.security;

import java.util.List;

public class IdentityUser {

    private String id;
    private String userName;
    private String PasswordHash;
    private String SecurityStamp;
    private List<String> roles;
    private List<String> claims;
    private List<String> logins;

    public IdentityUser() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPasswordHash() {
	return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
	PasswordHash = passwordHash;
    }

    public String getSecurityStamp() {
	return SecurityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
	SecurityStamp = securityStamp;
    }

    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

    public List<String> getClaims() {
	return claims;
    }

    public void setClaims(List<String> claims) {
	this.claims = claims;
    }

    public List<String> getLogins() {
	return logins;
    }

    public void setLogins(List<String> logins) {
	this.logins = logins;
    }

}
