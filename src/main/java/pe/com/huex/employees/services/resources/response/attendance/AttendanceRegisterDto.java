package pe.com.huex.employees.services.resources.response.attendance;

import pe.com.huex.employees.services.resources.dtos.AttendanceResponseDto;

public class AttendanceRegisterDto {
	private AttendanceResponseDto attendance = null;

	public AttendanceRegisterDto() {
	}

	public AttendanceRegisterDto attendance(AttendanceResponseDto attendance) {
		this.attendance = attendance;
		return this;
	}

}
