package pe.com.huex.customer.domain.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.Implement;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer_employee")
public class CustomerEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private Employee employee;

	@Column(name = "status", length = 50)
	private String status;

	@Column(name = "register_date")
	private Date registerDate;

	@Column(name = "observations", length = 200)
	private String observations;

}
