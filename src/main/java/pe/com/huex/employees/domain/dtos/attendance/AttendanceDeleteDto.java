package pe.com.huex.employees.domain.dtos.attendance;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;

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
