package pe.com.huex.employees.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee_discount")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private Employee employee;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	@Column(nullable = true, length = 512)
	private String observations;

	@Column(nullable = true, length = 64)
	private String status;

	@Column(nullable = true)
	private double charge;

}
