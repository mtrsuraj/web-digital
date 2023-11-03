package com.tech.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.info.entities.dtos.EmployeeDto;
import com.tech.info.services.EmployeeService;
import com.tech.info.utils.ResponceApi;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/web/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//CREATE EMPLOYEE
	
	@PostMapping("create-employee")
	ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		EmployeeDto createEmployee = this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);
	}
	
	//UPDATE EMPLOYEE
	@PutMapping("update-employee/{id}")
	ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") long employeeId, @Valid @RequestBody EmployeeDto employeeDto){
		EmployeeDto updateEmployee = this.employeeService.updateEmployee(employeeId, employeeDto);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.OK);
	}
	
	//GET EMPLOYEE LIST
	@GetMapping("get-all-employee")
	ResponseEntity<?>getEmployeeList(){
		List<EmployeeDto> listOfEmployee = this.employeeService.getListOfEmployee();
		return ResponseEntity.ok(listOfEmployee);
	}
	
	//FIND EMPLOYEE
	@GetMapping("employee/{id}")
	ResponseEntity<?>getEmployeeById(@PathVariable(name = "id") long employeeId){
		EmployeeDto employeeById = this.employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeById);
	}
	
	//DELETE EMPLOYEE
	@DeleteMapping("delete-employee/{id}")
	ResponseEntity<?>deleteEmployeeById(@PathVariable(name = "id") long employeeId){
		this.employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(new ResponceApi("Employee deleted successfull", true), HttpStatus.OK);
	}
	
	//SEARCH EMPLOYEE BY NAME
	@GetMapping("employees/name/{name}")
	ResponseEntity<List<EmployeeDto>> searchEmployeeName(@PathVariable(name = "name") String employeeName){
//		return this.employeeService.findByEmployeeNames(employeeName);
		List<EmployeeDto> findByEmployeeName = this.employeeService.findByEmployeeNames(employeeName);
		return new ResponseEntity<List<EmployeeDto>>(findByEmployeeName, HttpStatus.OK);
	}
	
	
	

}
