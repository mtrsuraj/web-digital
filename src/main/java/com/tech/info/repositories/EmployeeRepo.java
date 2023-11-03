package com.tech.info.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.info.entities.EmployeeDetails;



public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long>{
	
	 List<EmployeeDetails> findByEmployeeName(String employeeName);


}
