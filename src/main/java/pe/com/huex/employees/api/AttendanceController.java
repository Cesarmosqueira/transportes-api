package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IAttendanceService;
import pe.com.huex.employees.services.resources.dtos.AttendanceDto;
import pe.com.huex.employees.services.resources.response.AttendanceListResponse;
import pe.com.huex.employees.services.resources.response.AttendanceResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("attendances")
public class AttendanceController {

	@Autowired
	IAttendanceService attendanceService;

	@GetMapping
	public ResponseDto<AttendanceListResponse> listAttendance() {
		return attendanceService.listAttendances();
	}

	@GetMapping("{id}")
	public ResponseDto<AttendanceResponse> retrieveAttendance(@PathVariable Long id) {
		return attendanceService.retrieveAttendance(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceResponse> registerAttendance(@RequestBody AttendanceDto attendance)
			throws Exception {
		return attendanceService.registerAttendance(attendance);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceResponse> updateAttendance(@RequestBody AttendanceDto attendanceDto) throws IOException {
		return attendanceService.updateAttendance(attendanceDto);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto deleteAttendance(@PathVariable Long id) {
		return attendanceService.deleteAttendance(id);
	}

	@GetMapping(path = "{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<AttendanceListResponse> listEmployeeAttendanceByDate(@PathVariable String startDate, @PathVariable String endDate) throws ParseException {
		return attendanceService.listEmployeeAttendanceByDate(startDate, endDate);
	}
}
