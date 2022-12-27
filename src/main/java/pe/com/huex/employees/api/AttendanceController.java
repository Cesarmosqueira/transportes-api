package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.employees.services.AttendanceService;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceDeleteDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceListDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceRegisterDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceUpdateDto;
import pe.com.huex.employees.services.resources.dtos.AttendanceResponseDto;

@RestController
@RequestMapping("attendances")
public class AttendanceController {

	@Autowired
	AttendanceService employeeAttendanceService;

	// Get all
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceListDto> retrieveEmployeesAttendance() throws Exception {
		return employeeAttendanceService.listAttendances();
	}

	// Get by employee
	@GetMapping(path = "{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceListDto> retrieveAttendancesByEmployee(@PathVariable Long employeeId)
			throws Exception {
		return employeeAttendanceService.listAttendancesByEmployee(employeeId);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceRegisterDto> registerEmployeesAttendance(
			@RequestBody AttendanceResponseDto employeeAttendance)
			throws Exception {
		return employeeAttendanceService.registerAttendances(employeeAttendance);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceUpdateDto> updateEmployeesAttendance(
			@RequestBody AttendanceResponseDto employeeAttendance)
			throws Exception {
		return employeeAttendanceService.updateAttendances(employeeAttendance);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceDeleteDto> deleteAttendance(@PathVariable Long id)
			throws Exception {
		return employeeAttendanceService.deleteAttendance(id);
	}

}
