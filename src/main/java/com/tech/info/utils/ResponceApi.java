package com.tech.info.utils;

public class ResponceApi {
	
	private String message;
	private boolean stetus;
	public ResponceApi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponceApi(String message, boolean stetus) {
		super();
		this.message = message;
		this.stetus = stetus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStetus() {
		return stetus;
	}
	public void setStetus(boolean stetus) {
		this.stetus = stetus;
	}
	
	

}
