package com.tech.info.exceptions;

public class ResourceNotFoundException extends RuntimeException{

//	private static final long serialVersionUID = 1L;
	private String resource;
	
	private String fieldName;
	
	private String fieldId;

	public ResourceNotFoundException(String resource, String fieldName, String fieldId) {
		super(String.format("%s not found with %s: %s", resource, fieldName, fieldId));
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	
	
	
	

}
