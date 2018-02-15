package com.example.demo.web;

public class SearchForm {

	private Integer searchProductId;
	
	private String searchProductName;
	
	private Integer searchMakerId;
	
	private String searchMakerName;
	
	private String url;

	public Integer getSearchProductId() {
		return searchProductId;
	}

	public void setSearchProductId(Integer searchProductId) {
		this.searchProductId = searchProductId;
	}

	public String getSearchProductName() {
		return searchProductName;
	}

	public void setSearchProductName(String searchProductName) {
		this.searchProductName = searchProductName;
	}

	public Integer getSearchMakerId() {
		return searchMakerId;
	}

	public void setSearchMakerId(Integer searchMakerId) {
		this.searchMakerId = searchMakerId;
	}

	public String getSearchMakerName() {
		return searchMakerName;
	}

	public void setSearchMakerName(String searchMakerName) {
		this.searchMakerName = searchMakerName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
