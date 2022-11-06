package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.EmployeeService;
import pe.com.huex.employees.services.resources.dtos.employees.EmployeeListDto;
import pe.com.huex.employees.services.resources.dtos.employees.EmployeeRegisterDto;
import pe.com.huex.employees.services.resources.dtos.employees.EmployeeRetrieveDto;
import pe.com.huex.employees.services.resources.dtos.employees.EmployeeUpdateDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeListDto> listEmployees() throws Exception {
		return employeeService.listEmployees();
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeRetrieveDto> retrieveEmployees(@PathVariable Long id) throws Exception {
		return employeeService.retrieveEmployees(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeRegisterDto> registerEmployees(@RequestBody Employee employee) throws Exception {
		return employeeService.registerEmployees(employee);
	}

	@PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeUpdateDto> updateEmployees(@PathVariable Long id, @RequestBody Employee employee)
			throws Exception {
		return employeeService.updateEmployees(id, employee);
	}
}
