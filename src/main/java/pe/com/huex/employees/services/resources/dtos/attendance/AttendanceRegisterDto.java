package pe.com.huex.employees.services.resources.dtos.attendance;

import pe.com.huex.employees.services.resources.response.AttendanceResponseDto;

public class AttendanceRegisterDto {
	private AttendanceResponseDto attendance = null;

	public AttendanceRegisterDto() {
	}

	public AttendanceRegisterDto attendance(AttendanceResponseDto attendance) {
		this.attendance = attendance;
		return this;
	}

	public AttendanceResponseDto getAttendance() {
		return attendance;
	}

	public void setAttendance(AttendanceResponseDto attendance) {
		this.attendance = attendance;
	}

}
