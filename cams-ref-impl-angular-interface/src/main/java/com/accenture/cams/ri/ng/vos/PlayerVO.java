package com.accenture.cams.ri.ng.vos;

public class PlayerVO {

    private Long id;

    private String name;

    private Long rating;

    private Long contractId;

    private TeamVO team;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Long getRating() {
	return rating;
    }

    public void setRating(Long rating) {
	this.rating = rating;
    }

    public Long getContractId() {
	return contractId;
    }

    public void setContractId(Long contractId) {
	this.contractId = contractId;
    }

    public TeamVO getTeam() {
	return team;
    }

    public void setTeam(TeamVO team) {
	this.team = team;
    }

}