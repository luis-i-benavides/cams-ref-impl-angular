package com.accenture.cams.ri.ng.common;

import java.util.List;

public class RequestResult<D> {

    private D data;
    private List<ApplicationMessage> messages;

    public RequestResult(D data, List<ApplicationMessage> messages) {
	super();
	this.data = data;
	this.messages = messages;
    }

    public D getData() {
	return data;
    }

    public void setData(D data) {
	this.data = data;
    }

    public List<ApplicationMessage> getMessages() {
	return messages;
    }

    public void setMessages(List<ApplicationMessage> messages) {
	this.messages = messages;
    }

}
