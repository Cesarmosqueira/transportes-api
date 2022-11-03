package pe.com.huex.customers.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import pe.com.huex.customers.domain.entity.Client;
import pe.com.huex.employees.domain.entities.Employee;

@Data
@Entity
@Table(name = "client_employee")
public class ClientEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 32)
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date registerDate;

	@Column(nullable = false, length = 1024)
	private String observations;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clientEmployee", referencedColumnName = "id")
	private Employee employee;

}
