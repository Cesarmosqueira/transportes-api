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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employee_implement")
@NoArgsConstructor
public class EmployeeImplement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "implement_id")
	Implement implement;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date deliveryDate;

	@Column(nullable = true, length = 1024)
	private String observations;

};
