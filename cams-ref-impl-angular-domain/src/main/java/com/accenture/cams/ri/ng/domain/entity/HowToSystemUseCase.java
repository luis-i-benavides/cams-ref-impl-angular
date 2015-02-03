package com.accenture.cams.ri.ng.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "how_to_system_u_c")
public class HowToSystemUseCase implements Serializable {

	private static final long serialVersionUID = -1116768550153523498L;

	@Id
	@GeneratedValue
	@Column(name = "UcId")
	private String ucId;

	@Column(name = "name")
	private String name;

	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "date_updated")
	private Date dateUpdated;

	@Column(name = "link")
	private String link;

	@Column(name = "documentation")
	private String documentation;

	@Column(name = "html")
	private String html;

	/**
	 * @return the ucId
	 */
	public String getUcId() {
		return ucId;
	}

	/**
	 * @param ucId
	 *            the ucId to set
	 */
	public void setUcId(String ucId) {
		this.ucId = ucId;
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
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the documentation
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * @param documentation
	 *            the documentation to set
	 */
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html
	 *            the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HowToSystemUseCase [ucId=" + ucId + ", name=" + name
				+ ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + ", link=" + link + ", documentation="
				+ documentation + ", html=" + html + "]";
	}

}
