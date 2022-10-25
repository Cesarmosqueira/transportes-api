package pe.com.huex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.common.EntityDtoConverter;
import pe.com.huex.services.EmployeeService;
import pe.com.huex.entities.Employee;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EntityDtoConverter entityDtoConverter;

	@PostMapping
	public ResponseEntity<Employee> registerEmployee(@Validated @RequestBody Employee employee)
			throws Exception {
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> retrieveEmployee(@PathVariable Long id) throws Exception {
		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> listEmployees() throws Exception {
		List<Employee> employees = employeeService.listEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Validated @RequestBody Employee employee)
			throws Exception {
		Employee updated = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

}
