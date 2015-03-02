package com.accenture.cams.ri.ng.vos;

import java.util.Collection;
import java.util.Date;

public class ContractVO {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Float value;
    private Boolean transferable;
    private Long contractPlayerId;
    private Collection<SaisonVO> saisons;

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

    public Collection<SaisonVO> getSaisons() {
	return saisons;
    }

    public void setSaisons(Collection<SaisonVO> saisons) {
	this.saisons = saisons;
    }

    @Override
    public String toString() {
	return "ContractVO [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", value=" + value
		+ ", transferable=" + transferable + ", contractPlayerId=" + contractPlayerId + ", saisons=" + saisons
		+ "]";
    }

}
