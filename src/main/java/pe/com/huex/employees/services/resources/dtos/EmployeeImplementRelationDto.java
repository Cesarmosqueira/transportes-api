package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import lombok.Data;
import pe.com.huex.employees.domain.entities.EmployeeImplement;

@Data
public class EmployeeImplementRelationDto {

	private Long id;
	private EmployeeResponseDto employee;
	private Date date;
	private String observations;

	public EmployeeImplementRelationDto(EmployeeImplement employeeImplement) {
		this.id = employeeImplement.getId();
		this.employee = new EmployeeResponseDto(employeeImplement.getEmployee());
		this.date = employeeImplement.getDate();
		this.observations = employeeImplement.getObservations();
	}

}
