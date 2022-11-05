package pe.com.huex.employees.domain.dtos.attendance;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;

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
