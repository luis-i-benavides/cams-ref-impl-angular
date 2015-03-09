package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = -8610560759465845473L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Long rating;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_fk")
    private Contract contract;

    @OneToMany(mappedBy = "contractPlayerId", fetch = FetchType.EAGER)
    private Collection<Contract> contracts;

    @Column(name = "team_business_id")
    private String teamBusinessId;

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

    public Contract getContract() {
	return contract;
    }

    public void setContract(Contract contract) {
	this.contract = contract;
    }

    public Collection<Contract> getContracts() {
	return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
	this.contracts = contracts;
    }

    public String getTeamBusinessId() {
	return teamBusinessId;
    }

    public void setTeamBusinessId(String teamBusinessId) {
	this.teamBusinessId = teamBusinessId;
    }

}