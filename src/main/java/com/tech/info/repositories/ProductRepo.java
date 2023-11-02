package com.tech.info.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.info.entities.EmployeeDetails;
import com.tech.info.entities.ProductDetails;

public interface ProductRepo extends JpaRepository<ProductDetails, Long>{
	
	//SEARCH BY EMPLOYEE
	List<ProductDetails> findByEmployeeDetails(EmployeeDetails employeeDetails);

}
