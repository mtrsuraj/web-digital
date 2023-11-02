package com.tech.info.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.info.entities.EmployeeDetails;

public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long>{
	


}
