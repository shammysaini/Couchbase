package couch.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import couch.dto.EmployeeRequest;
import couch.dto.EmployeeResponse;
import couch.model.Employee;
import couch.repo.EmployeeRepo;
import couch.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
		log.info("Enter on saveEmployee method present in EmpServiceImpl");
		Employee emp = new Employee();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		emp.setName(employeeRequest.getName());
		emp.setMobile(employeeRequest.getMobile());
		employeeRepo.save(emp);
		employeeResponse.setEmployee(emp);
		return employeeResponse;

	}

	@Override
	public List<EmployeeResponse> fetchAll() {
		log.info("Enter on fetchAll method present in EmpServiceImpl");
		//List<Employee> listEmployee = employeeRepo.findAll();
		List<Employee> listEmployee = employeeRepo.findAllEmployee();
		List<EmployeeResponse> listEmployeeRes = new ArrayList<>();
		if (!listEmployee.isEmpty()) {
			for (Employee emp : listEmployee) {
				EmployeeResponse employeeResponse = new EmployeeResponse();
				employeeResponse.setEmployee(emp);		
				listEmployeeRes.add(employeeResponse);

			}

		}
		
			else {
				Collections.emptyList();
			}
		
		return listEmployeeRes;
	}

	@Override
	public EmployeeResponse fetchById(String id) {
		log.info("Enter on fetchById method present in EmpServiceImpl{}",id);
		 Employee employee = employeeRepo.findById(id).get();
		 EmployeeResponse  employeeResponse = new EmployeeResponse();
		 employeeResponse.setEmployee(employee);
		 
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getById(String id,String name) {
		log.info("Enter on getById method present in EmpServiceImpl{}",name);
		 Employee employee = employeeRepo.getEmployeeByIdAndMobile(id,name);
		 EmployeeResponse  employeeResponse = new EmployeeResponse();
		 employeeResponse.setEmployee(employee);
		 
		return employeeResponse;
	}

}
