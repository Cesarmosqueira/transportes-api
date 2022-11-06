package pe.com.huex.employees.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.response.DiscountResponseDto;

@Data
@Entity
@Table(name = "employee_discount")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	Employee employee;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	@Column(nullable = true, length = 512)
	private String observations;

	@Column(nullable = true)
	private double charge;

	public EmployeeDiscount(DiscountResponseDto discountRequestDto, Employee emp) {
		this.date = discountRequestDto.getDate();
		this.observations = discountRequestDto.getObservations();
		this.charge = discountRequestDto.getCharge();
		this.employee = emp;
	}

}
