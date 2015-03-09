<<<<<<< HEAD
package com.accenture.cams.ri.ng.vos;

public class PlayerVO {

    private Long id;
    private String name;
    private Long rating;
    private ContractVO contract;
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

    public ContractVO getContract() {
	return contract;
    }

    public void setContract(ContractVO contract) {
	this.contract = contract;
    }

    public String getTeamBusinessId() {
	return teamBusinessId;
    }

    public void setTeamBusinessId(String teamBusinessId) {
	this.teamBusinessId = teamBusinessId;
    }

    @Override
    public String toString() {
	return "PlayerVO [id=" + id + ", name=" + name + ", rating=" + rating + ", contract=" + contract
		+ ", teamBusinessId=" + teamBusinessId + "]";
    }

=======
package com.accenture.cams.ri.ng.vos;

public class PlayerVO {

    private Long id;
    private String name;
    private Long rating;
    private ContractVO contract;
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

    public ContractVO getContract() {
	return contract;
    }

    public void setContract(ContractVO contract) {
	this.contract = contract;
    }

    public String getTeamBusinessId() {
	return teamBusinessId;
    }

    public void setTeamBusinessId(String teamBusinessId) {
	this.teamBusinessId = teamBusinessId;
    }

    @Override
    public String toString() {
	return "PlayerVO [id=" + id + ", name=" + name + ", rating=" + rating + ", contract=" + contract
		+ ", teamBusinessId=" + teamBusinessId + "]";
    }

>>>>>>> 798d7c92beb3a0166d746c8d12aa60b1be6d02ae
}