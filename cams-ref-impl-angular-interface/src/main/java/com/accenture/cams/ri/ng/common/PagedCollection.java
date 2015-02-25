package com.accenture.cams.ri.ng.common;

import java.util.List;

public class PagedCollection<T> {

    private int page;
    private int pageSize;
    private long totalCount;
    private List<T> data;
    private String orderBy;
    private boolean orderByDirection;

    public PagedCollection(int page, int pageSize, long totalCount, List<T> data, String orderBy,
	    boolean orderByDirection) {
	super();
	this.page = page;
	this.pageSize = pageSize;
	this.totalCount = totalCount;
	this.data = data;
	this.orderBy = orderBy;
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

    public long getTotalCount() {
	return totalCount;
    }

    public void setTotalCount(long totalCount) {
	this.totalCount = totalCount;
    }

    public List<T> getData() {
	return data;
    }

    public void setData(List<T> data) {
	this.data = data;
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

}
