package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import lombok.*;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.domain.entities.Implement;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeImplementDto {

	private Long id;
	private EmployeeDto employee;
	private ImplementDto implement;
	private Date deliveryDate;
	private String observations;

}
