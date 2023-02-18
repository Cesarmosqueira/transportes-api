package pe.com.huex.employees.services.resources.dtos;

import lombok.*;
import pe.com.huex.employees.domain.entities.Employee;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {

	private Long id;
	private EmployeeDto employee;
	private Date date;
	private String observations;
	private String status;
	private double charge;

}
