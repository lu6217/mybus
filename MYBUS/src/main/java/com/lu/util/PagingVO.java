package com.lu.util;

import java.util.List;

public class PagingVO {

	private String pageIndex;

	private String pageSize;

	/**
	 * aa,asc|bb,desc
	 */
	private String orderName;

	private List<?> details;

	private Long count;

	private String locale;

	public PagingVO() {
		this.pageIndex = "1";
		//this.pageSize="10";
		this.pageSize = SystemConfigHolder.instance().getInterger("system.pagesize.default",15).toString();
	}
	
	public PagingVO(String pageIndex, String size) {
		this.pageIndex = pageIndex;
		this.pageSize = size;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<?> getDetails() {
		return details;
	}

	public void setDetails(List<?> details) {
		this.details = details;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "PagingVO [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", orderName=" + orderName + ", details=" + details
				+ ", count=" + count + ", locale=" + locale + "]";
	}

}
