package com.tech.info.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/*we can also use lombok 
 * 
 * @Data ---> Getter & Setter
 * 
 * @NoArgsCunstructor
 * 
 * @AllArgsCunstructor
 * 
*/

@Entity
@Table(name = "product_details")
public class ProductDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_description")
	private String productDescription;
	@CreationTimestamp
	@Column(name="created_on")
	private Date productCreationDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private EmployeeDetails employeeDetails;

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetails(long productId, String productName, String productDescription, Date productCreationDate,
			EmployeeDetails employeeDetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCreationDate = productCreationDate;
		this.employeeDetails = employeeDetails;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getProductCreationDate() {
		return productCreationDate;
	}

	public void setProductCreationDate(Date productCreationDate) {
		this.productCreationDate = productCreationDate;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	
	
}
