package com.accenture.cams.ri.ng.vos;

import java.io.Serializable;
import java.util.Date;

public class HowToSystemUseCaseVO implements Serializable {

    private static final long serialVersionUID = -1116768550153523498L;

    private String ucId;

    private String name;

    private Date dateCreated;

    private Date dateUpdated;

    private String link;

    private String documentation;

    private String html;

    public HowToSystemUseCaseVO() {
	super();
    }

    public String getUcId() {
	return ucId;
    }

    public void setUcId(String ucId) {
	this.ucId = ucId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the dateCreated
     */
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

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    public String getDocumentation() {
	return documentation;
    }

    public void setDocumentation(String documentation) {
	this.documentation = documentation;
    }

    public String getHtml() {
	return html;
    }

    public void setHtml(String html) {
	this.html = html;
    }

}
