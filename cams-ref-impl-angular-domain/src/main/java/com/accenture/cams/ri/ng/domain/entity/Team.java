package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    private static final long serialVersionUID = -7973124895815987320L;

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "team", targetEntity = Player.class, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Player> players;

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
     * @return the dateCreated
     */
    public Date getDateCreated() {
	return dateCreated;
    }

    /**
     * @param dateCreated
     *            the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    /**
     * @return the dateUpdated
     */
    public Date getDateUpdated() {
	return dateUpdated;
    }

    /**
     * @param dateUpdated
     *            the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated) {
	this.dateUpdated = dateUpdated;
    }

    /**
     * @return the image
     */
    public String getImage() {
	return image;
    }

    /**
     * @param image
     *            the image to set
     */
    public void setImage(String image) {
	this.image = image;
    }

    public Collection<Player> getPlayers() {
	return players;
    }

    public void setPlayers(Collection<Player> players) {
	this.players = players;
    }

}
