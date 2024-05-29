package couch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import couch.dto.EmployeeRequest;
import couch.dto.EmployeeResponse;
import couch.service.EmpService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmpService empService;

	@PostMapping("/save")
	public ResponseEntity<EmployeeResponse> saveCustomer(@RequestBody EmployeeRequest employeeRequest) {
		EmployeeResponse empResponse = null;
		empResponse = empService.saveEmployee(employeeRequest);
		if (empResponse != null) {
			return new ResponseEntity<EmployeeResponse>(empResponse, HttpStatus.CREATED);

		} else {

			return new ResponseEntity<EmployeeResponse>(empResponse, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/fetchAll")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<EmployeeResponse>> getAllCustomers() {
		List<EmployeeResponse> listEmpResponse = new ArrayList<>();
		listEmpResponse = empService.fetchAll();
		if (!listEmpResponse.isEmpty()) {
			return new ResponseEntity<List<EmployeeResponse>>(listEmpResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<EmployeeResponse>>(listEmpResponse, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<EmployeeResponse> getEachCustomers(@PathVariable("id") String id) {
		EmployeeResponse employeeResponse = empService.fetchById(id);

		if (employeeResponse != null) {
			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/fetch/emp/{id}/{mobile}")
	public ResponseEntity<EmployeeResponse> getEachEmployee(@PathVariable("id") String id,@PathVariable("mobile") String mobile) {
		log.info("Enter in getEachEmployee method present in EmployeeController class {},{} ",id,mobile);
		EmployeeResponse employeeResponse = empService.getById(id,mobile);

		if (employeeResponse != null) {
			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);

		} else {

			return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.BAD_REQUEST);

		}
	}
	
	public String  show() {
		
		return "shammy saini";
		
	}

}
