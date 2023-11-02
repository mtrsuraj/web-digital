package com.tech.info.serviceImpl;

import java.util.List;

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
		EmployeeDetails gotEmployeeId = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","id", String.valueOf(employeeId)));
		gotEmployeeId.setEmployeeName(employeeDto.getEmployeeName());
		gotEmployeeId.setEmployeeEmail(employeeDto.getEmployeeEmail());
		gotEmployeeId.setEmployeeAddress(employeeDto.getEmployeeAddress());
		gotEmployeeId.setEmployeeContactNumber(employeeDto.getEmployeeContactNumber());
		gotEmployeeId.setEmployeeJoining(employeeDto.getEmployeeJoining());
		EmployeeDetails saveEmployeeDetails = this.employeeRepo.save(gotEmployeeId);
		return this.modelMapper.map(saveEmployeeDetails, EmployeeDto.class);
		
	}

	@Override
	public EmployeeDto getEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getListOfEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(long employeeId) {
		// TODO Auto-generated method stub

	}

}
