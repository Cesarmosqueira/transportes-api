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
	private Employee employee;
	private Date date;
	private String observations;
	private double charge;

}
