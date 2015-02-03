package com.accenture.cams.ri.ng.common;

public class ApplicationMessage {

	private String severity;
	private String message;

	public ApplicationMessage() {
		super();
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
