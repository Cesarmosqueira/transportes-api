package pe.com.huex.employees.services.resources.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.Employee;

import java.util.Date;

@Data
@NoArgsConstructor
public class DiscountDto {

	private Long id;
	private Employee employee;
	private Date date;
	private String observations;
	private double charge;

}
