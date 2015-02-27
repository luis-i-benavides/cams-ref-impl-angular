package com.accenture.cams.ri.ng.vos;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class PlayerVO {

    private Long id;

    private String name;

    private Long rating;

    private Long contractId;

    private Collection<ContractVO> contracts;

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

    public Collection<ContractVO> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<ContractVO> contracts) {
        this.contracts = contracts;
    }

    @JsonBackReference
    public TeamVO getTeam() {
	return team;
    }

    public void setTeam(TeamVO team) {
	this.team = team;
    }

}