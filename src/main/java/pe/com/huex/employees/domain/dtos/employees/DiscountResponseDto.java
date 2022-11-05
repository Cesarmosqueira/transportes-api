package pe.com.huex.employees.domain.dtos.employees;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;

@Data
@NoArgsConstructor
public class DiscountResponseDto {
	private Long id;

	private Long employeeId;

	private Date date;

	private String observations;

	private double charge;

	public DiscountResponseDto(EmployeeDiscount discount) {
		this.id = discount.getId();
		this.employeeId = discount.getEmployee().getId();
		this.date = discount.getDate();
		this.observations = discount.getObservations();
		this.charge = discount.getCharge();

	}
}
