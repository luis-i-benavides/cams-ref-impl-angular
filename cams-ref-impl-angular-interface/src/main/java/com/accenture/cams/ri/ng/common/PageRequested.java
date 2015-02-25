package com.accenture.cams.ri.ng.common;

public class PageRequested {
    private String orderBy;
    private boolean orderByDirection;
    private int page;
    private int pageSize;

    public PageRequested() {
	super();
    }

    public String getOrderBy() {
	return orderBy;
    }

    public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
    }

    public boolean isOrderByDirection() {
	return orderByDirection;
    }

    public void setOrderByDirection(boolean orderByDirection) {
	this.orderByDirection = orderByDirection;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

}
