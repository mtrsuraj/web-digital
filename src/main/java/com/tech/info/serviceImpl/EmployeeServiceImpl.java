package com.tech.info.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.info.entities.EmployeeDetails;
import com.tech.info.entities.dtos.EmployeeDto;
import com.tech.info.exceptions.ResourceNotFoundException;
import com.tech.info.repositories.EmployeeRepo;
import com.tech.info.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		EmployeeDetails employeeDetails = this.modelMapper.map(employeeDto, EmployeeDetails.class);
		EmployeeDetails saveEmployeeDetails = this.employeeRepo.save(employeeDetails);
		return this.modelMapper.map(saveEmployeeDetails, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(long employeeId, EmployeeDto employeeDto) {
//		System.out.println(String.valueOf(employeeId));
		EmployeeDetails gotEmployeeId = this.employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(employeeId)));
		gotEmployeeId.setEmployeeName(employeeDto.getEmployeeName());
		gotEmployeeId.setEmployeeEmail(employeeDto.getEmployeeEmail());
		gotEmployeeId.setEmployeeAddress(employeeDto.getEmployeeAddress());
		gotEmployeeId.setEmployeeContactNumber(employeeDto.getEmployeeContactNumber());
		EmployeeDetails saveEmployeeDetails = this.employeeRepo.save(gotEmployeeId);
		return this.modelMapper.map(saveEmployeeDetails, EmployeeDto.class);

	}

	@Override
	public EmployeeDto getEmployeeById(long employeeId) {
		EmployeeDetails employeeDetails = this.employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(employeeId)));
		return this.modelMapper.map(employeeDetails, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getListOfEmployee() {
		List<EmployeeDetails> allEmployee = this.employeeRepo.findAll();
		List<EmployeeDto> collectEmployee = allEmployee.stream()
				.map((employee) -> this.modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
		return collectEmployee;
	}

	@Override
	public void deleteEmployee(long employeeId) {
		EmployeeDetails employeeDetails = this.employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(employeeId)));
		this.employeeRepo.deleteById(employeeId);

	}

	@Override
	public List<EmployeeDto> findByEmployeeNames(String employeeName) {
		List<EmployeeDetails> findByEmployeeName = this.employeeRepo.findByEmployeeName(employeeName);
		List<EmployeeDto> collect = findByEmployeeName.stream()
				.map((employee) -> this.modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
		return collect;
	}

}
