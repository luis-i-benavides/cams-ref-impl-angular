package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saison")
public class Saison implements Serializable {

    private static final long serialVersionUID = -8871711901415192056L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "saison_contract_fk")
    private Long saisonContractId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "played")
    private Integer played;

    @Column(name = "score")
    private Integer score;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getSaisonContractId() {
	return saisonContractId;
    }

    public void setSaisonContractId(Long saisonContractId) {
	this.saisonContractId = saisonContractId;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getPlayed() {
	return played;
    }

    public void setPlayed(Integer played) {
	this.played = played;
    }

    public Integer getScore() {
	return score;
    }

    public void setScore(Integer score) {
	this.score = score;
    }

}
