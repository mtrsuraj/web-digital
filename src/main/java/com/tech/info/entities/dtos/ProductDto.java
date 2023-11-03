package com.tech.info.entities.dtos;

import java.util.Date;

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

public class ProductDto {
	
	private long productId;
	
	@NotEmpty
	@Size(min = 4, max = 20, message = "Name not valid")
	@Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Name not valid")
	private String productName;
	@NotEmpty
	@Size(min = 6, max = 50, message = "Employee address more than 6 character!!")
	private String productDescription;
	
	private Date productCreationDate;
	
//	private EmployeeDto employeeDto;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(long productId, String productName, String productDescription, Date productCreationDate,
			EmployeeDto employeeDto) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCreationDate = productCreationDate;
//		this.employeeDto = employeeDto;
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

//	public EmployeeDto getEmployeeDto() {
//		return employeeDto;
//	}
//
//	public void setEmployeeDto(EmployeeDto employeeDto) {
//		this.employeeDto = employeeDto;
//	}
	
	
	
	

}
