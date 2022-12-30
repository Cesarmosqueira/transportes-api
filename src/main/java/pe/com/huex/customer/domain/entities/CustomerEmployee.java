package pe.com.huex.customer.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer_employee")
public class CustomerEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_customer")
	private Long idCustomer;

	@Column(name = "id_employee")
	private Long idEmployee;

	@Column(name = "status", length = 50)
	private String status;

	@Column(name = "register_date")
	private Date registerDate;

	@Column(name = "observations", length = 200)
	private String observations;

}
