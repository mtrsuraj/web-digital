package com.tech.info.entities.dtos;

import java.util.Date;


/*we can also use lombok 
 * @Data ---> Getter & Setter
 * 
 * @NoArgsCunstructor
 * 
 * @AllArgsCunstructor
 * 
*/

public class EmployeeDto {
	
	private long employeeId;
	
	private String employeeName;
	
	private String employeeEmail;
	
	private String employeeContactNumber;
	
	private String employeeAddress;
	
	private Date employeeJoining;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public EmployeeDto(long employeeId, String employeeName, String employeeEmail, String employeeContactNumber,
			String employeeAddress, Date employeeJoining) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeContactNumber = employeeContactNumber;
		this.employeeAddress = employeeAddress;
		this.employeeJoining = employeeJoining;
	}



	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeContactNumber() {
		return employeeContactNumber;
	}

	public void setEmployeeContactNumber(String employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Date getEmployeeJoining() {
		return employeeJoining;
	}

	public void setEmployeeJoining(Date employeeJoining) {
		this.employeeJoining = employeeJoining;
	}

	
	
	

}
