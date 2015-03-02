package com.accenture.cams.ri.ng.vos;

public class SaisonVO {

    private Long id;
    private Long saisonContractId;
    private Integer year;
    private Integer played;
    private Integer score;

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

    @Override
    public String toString() {
	return "SaisonVO [id=" + id + ", saisonContractId=" + saisonContractId + ", year=" + year + ", played="
		+ played + ", score=" + score + "]";
    }

}
