package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.com.huex.employees.services.resources.dtos.AttendanceDto;

@Getter
@Setter
public class AttendanceResponse {
	private AttendanceDto attendance = null;

	public AttendanceResponse attendance(AttendanceDto attendanceDto) {
		this.attendance = attendanceDto;
		return this;
	}

}
