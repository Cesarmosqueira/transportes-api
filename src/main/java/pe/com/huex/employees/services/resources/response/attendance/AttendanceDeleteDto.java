package pe.com.huex.employees.services.resources.response.attendance;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.services.resources.dtos.AttendanceResponseDto;

public class AttendanceDeleteDto {
	private AttendanceResponseDto attendance = null;

	public AttendanceDeleteDto() {
	}

	public AttendanceDeleteDto attendance(EmployeeAttendance attendance) {
		this.attendance = new AttendanceResponseDto(attendance);
		return this;
	}

	public AttendanceResponseDto get() {
		return attendance;
	}

	public void set(AttendanceResponseDto attendance) {
		this.attendance = attendance;
	}

}
