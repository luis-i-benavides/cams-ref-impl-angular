package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @Column(name = "contract_fk")
    private Long contractId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_business_id")
    @JsonBackReference
    private Team team;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the rating
     */
    public Long getRating() {
	return rating;
    }

    /**
     * @param rating
     *            the rating to set
     */
    public void setRating(Long rating) {
	this.rating = rating;
    }

    /**
     * @return the contractId
     */
    public Long getContractId() {
	return contractId;
    }

    /**
     * @param contractId
     *            the contractId to set
     */
    public void setContractId(Long contractId) {
	this.contractId = contractId;
    }

    public Team getTeam() {
	return team;
    }

    public void setTeam(Team team) {
	this.team = team;
    }

}
