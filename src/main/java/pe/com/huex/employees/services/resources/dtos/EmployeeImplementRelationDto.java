package pe.com.huex.employees.services.resources.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeImplementRelationDto {

	private Long id;
	private EmployeeDto employee;
	private Date date;
	private String observations;

}
