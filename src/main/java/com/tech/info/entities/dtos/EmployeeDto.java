package com.tech.info.entities.dtos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

	@NotEmpty
	@Size(min = 4, max = 20, message = "Name not valid")
	@Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Name not valid")
	private String employeeName;
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@Size(min = 4, max = 20, message = "Email more than 4 character with special symbol")
	private String employeeEmail;
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})", message = "Number should be 10 without special symbol")
	@Size(min = 10, max = 12)
	private String employeeContactNumber;

	@NotEmpty
	@Size(min = 6, max = 50, message = "Employee address more than 6 character!!")
	private String employeeAddress;
	
	@CreationTimestamp
	private LocalDateTime employeeJoining;



	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
//		System.out.println(employeeName);
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

	public LocalDateTime getEmployeeJoining() {
		return employeeJoining;
	}

	public void setEmployeeJoining(LocalDateTime employeeJoining) {
		this.employeeJoining = employeeJoining;
	}

}
