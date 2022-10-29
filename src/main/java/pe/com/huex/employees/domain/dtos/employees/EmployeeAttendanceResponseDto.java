package pe.com.huex.employees.domain.dtos.employees;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeAttendanceResponseDto {
	private Date date;
	private String state;
	private Long employee_id;
}
