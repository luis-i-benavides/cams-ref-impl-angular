package com.accenture.cams.ri.ng.vos;

import java.util.Collection;
import java.util.Date;

public class TeamVO {

    private Long id;

    private String name;

    private Date dateCreated;

    private Date dateUpdated;

    private String image;

    private Collection<PlayerVO> players;

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

    public Date getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
	return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
	this.dateUpdated = dateUpdated;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public Collection<PlayerVO> getPlayers() {
	return players;
    }

    public void setPlayers(Collection<PlayerVO> players) {
	this.players = players;
    }

}
