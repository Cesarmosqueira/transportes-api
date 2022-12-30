package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.EmployeeImplement;

@Data
@NoArgsConstructor
public class EmployeeImplementDto {

	private Long id;
	private Long employeeId;
	private Long implementId;
	private Date date;
	private String observations;

	public EmployeeImplementDto(EmployeeImplement employeeImplement) {
		this.id = employeeImplement.getId();
		this.employeeId = employeeImplement.getEmployee().getId();
		this.implementId = employeeImplement.getImplement().getId();
		this.date = employeeImplement.getDate();
		this.observations = employeeImplement.getObservations();
	}
}
