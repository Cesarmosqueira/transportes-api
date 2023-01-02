package pe.com.huex.customer.domain.entities;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.Implement;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer_employee")
public class CustomerEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Column(name = "status", length = 50)
	private String status;

	@Column(name = "register_date")
	private Date registerDate;

	@Column(name = "observations", length = 200)
	private String observations;

}
