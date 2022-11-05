package pe.com.huex.employees.services.resources.dtos.attendance;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.services.resources.response.AttendanceResponseDto;

public class AttendanceUpdateDto {
	private AttendanceResponseDto attendance = null;

	public AttendanceUpdateDto() {
	}

	public AttendanceUpdateDto attendance(EmployeeAttendance attendance) {
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
