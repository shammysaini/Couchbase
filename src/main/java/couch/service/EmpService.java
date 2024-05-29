package couch.service;

import java.util.List;

import couch.dto.EmployeeRequest;
import couch.dto.EmployeeResponse;

public interface EmpService {

	EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

	List<EmployeeResponse> fetchAll();
	
	EmployeeResponse fetchById(String id);
	
	EmployeeResponse getById(String id,String name);

}
