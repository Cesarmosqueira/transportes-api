package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IEmployeeService;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;
import pe.com.huex.employees.services.resources.response.EmployeeListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping
	public ResponseDto<EmployeeListResponse> listCheckLists() {
		return employeeService.listEmployees();
	}

	@GetMapping("{id}")
	public ResponseDto<EmployeeResponse> retrieveCheckList(@PathVariable Long id) {
		return employeeService.retrieveEmployee(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeResponse> registerEmployee(
			@RequestBody EmployeeDto employee)
			throws Exception {
		return employeeService.registerEmployee(employee);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeResponse> updateEmployee(
			@RequestBody EmployeeDto employeeDto) throws IOException {
		return employeeService.updateEmployee(employeeDto);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}


}
