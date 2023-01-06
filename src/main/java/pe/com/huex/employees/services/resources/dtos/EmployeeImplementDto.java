package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import lombok.*;
import pe.com.huex.employees.domain.entities.EmployeeImplement;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeImplementDto {

	private Long id;
	private Long employeeId;
	private Long implementId;
	private Date deliveryDate;
	private String observations;

}
