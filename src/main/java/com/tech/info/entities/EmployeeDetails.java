package com.tech.info.entities;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



/*we can also use lombok 
 * @Data ---> Getter & Setter
 * 
 * @NoArgsCunstructor
 * 
 * @AllArgsCunstructor
 * 
*/


@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "employee_email")
	private String employeeEmail;
	@Column(name = "employee_contact_number")
	private String employeeContactNumber;
	@Column(name = "employee_address")
	private String employeeAddress;
	@Column(name = "employee_joined_on")
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH")
	private LocalDateTime employeeJoining;

	@OneToMany(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
	private List<ProductDetails> productDetails = new ArrayList<>();

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EmployeeDetails(long employeeId, String employeeName, String employeeEmail, String employeeContactNumber,
			String employeeAddress, LocalDateTime employeeJoining, List<ProductDetails> productDetails) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeContactNumber = employeeContactNumber;
		this.employeeAddress = employeeAddress;
		this.employeeJoining = employeeJoining;
		this.productDetails = productDetails;
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



	

	public LocalDateTime getEmployeeJoining() {
		return employeeJoining;
	}

	public void setEmployeeJoining(LocalDateTime employeeJoining) {
		this.employeeJoining = employeeJoining;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

}
