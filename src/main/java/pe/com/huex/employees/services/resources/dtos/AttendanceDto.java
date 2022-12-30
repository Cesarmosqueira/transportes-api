package pe.com.huex.employees.services.resources.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.com.huex.employees.domain.entities.Employee;

import java.util.Date;

@Data
@AllArgsConstructor
public class AttendanceDto {

	private Long id;

	private Date date;

	private String state;

	private Employee employee;
}