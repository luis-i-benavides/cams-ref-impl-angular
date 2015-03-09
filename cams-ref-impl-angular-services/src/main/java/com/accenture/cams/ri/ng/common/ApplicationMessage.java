package com.accenture.cams.ri.ng.common;

public class ApplicationMessage {

    private String severity;
    private String message;

    public ApplicationMessage() {
	super();
    }

    public ApplicationMessage(String severity, String message) {
	super();
	this.severity = severity;
	this.message = message;
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
