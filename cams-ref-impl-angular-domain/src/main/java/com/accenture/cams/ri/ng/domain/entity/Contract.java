package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = -4396332783203320988L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "value")
    private Float value;

    @Column(name = "transferable")
    private Boolean transferable;

    @Column(name = "contract_player_fk")
    private Long contractPlayerId;

    @OneToMany(mappedBy = "saisonContractId", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Collection<Saison> saisons;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public Float getValue() {
	return value;
    }

    public void setValue(Float value) {
	this.value = value;
    }

    public Boolean getTransferable() {
	return transferable;
    }

    public void setTransferable(Boolean transferable) {
	this.transferable = transferable;
    }

    public Long getContractPlayerId() {
	return contractPlayerId;
    }

    public void setContractPlayerId(Long contractPlayerId) {
	this.contractPlayerId = contractPlayerId;
    }

    public Collection<Saison> getSaisons() {
	return saisons;
    }

    public void setSaisons(Collection<Saison> saisons) {
	this.saisons = saisons;
    }

}
