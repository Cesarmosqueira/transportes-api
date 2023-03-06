package pe.com.huex.employees.services.resources.dtos;

import lombok.*;
import pe.com.huex.employees.domain.entities.Employee;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

	private Long id;

	private RelationsEmployeeDto employee;

	private Date attendanceDate;

	private String status;

}
