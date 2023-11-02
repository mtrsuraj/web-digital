package com.tech.info.services;

import java.util.List;

import com.tech.info.entities.dtos.EmployeeDto;

public interface EmployeeService {
	
	//CREATE EMPLOYEE
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	//UPDATE EMPLOYEE
	EmployeeDto updateEmployee(long employeeId, EmployeeDto employeeDto);
	
	//GET EMPLOYEE BY ID
	EmployeeDto getEmployeeById(long employeeId);
	
	//GET EMPLOYEE LIST
	List<EmployeeDto> getListOfEmployee();
	
	//DELETE EMPLOYEE
	void deleteEmployee(long employeeId);
	
	

}
