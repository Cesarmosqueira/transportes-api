package pe.com.huex.dto.Employee;

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
