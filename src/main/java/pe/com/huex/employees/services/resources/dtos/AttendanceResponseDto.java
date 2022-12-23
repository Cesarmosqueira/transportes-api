package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.com.huex.employees.domain.entities.EmployeeAttendance;

@Data
@AllArgsConstructor
public class AttendanceResponseDto {
	private Date date;
	private String state;
	private Long employee_id;

	public AttendanceResponseDto(EmployeeAttendance attendance) {
		this.date = attendance.getDate();
		this.state = attendance.getState();
		this.employee_id = attendance.getEmployee().getId();
	}
}
