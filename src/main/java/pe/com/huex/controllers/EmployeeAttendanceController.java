package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.dto.Employee.EmployeeAttendanceRegisterDto;
import pe.com.huex.dto.Employee.EmployeeAttendanceResponseDto;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.entities.EmployeeAttendance;
import pe.com.huex.services.EmployeeAttendanceService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("attendance")
public class EmployeeAttendanceController {

	@Autowired
	EmployeeAttendanceService employeeAttendanceService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<EmployeeAttendanceRegisterDto> registerEmployeesAttendance(
			@RequestBody EmployeeAttendanceResponseDto employeeAttendance)
			throws Exception {
		return employeeAttendanceService.registerEmployeeAttendances(employeeAttendance);
	}

}