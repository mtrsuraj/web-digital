package com.tech.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.info.entities.dtos.EmployeeDto;
import com.tech.info.services.EmployeeService;

@RestController
@RequestMapping("/web/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//CREATE EMPLOYEE
	
	@PostMapping("create-employee")
	ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto createEmployee = this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
	}
	
	//UPDATE EMPLOYEE
	
	//GET EMPLOYEE LIST
	
	//FIND EMPLOYEE
	
	//DELETE EMPLOYEE

}
