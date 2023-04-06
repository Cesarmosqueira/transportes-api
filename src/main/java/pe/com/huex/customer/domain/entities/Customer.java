package pe.com.huex.customer.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.customer.services.resources.dto.CustomerDto;
import pe.com.huex.warehouse.domain.model.entity.InvoicedProduct;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 32)
	private String ruc;

	@Column(nullable = false, length = 128)
	private String socialReason;

	@Column(nullable = true, length = 64)
	private String bankAccount;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date registerDate;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CustomerEmployee> customerEmployees = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
	private List<Rate> rates = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<InvoicedProduct> invoicedProducts = new ArrayList<>();



	public Customer(CustomerDto customerDto) {
		this.ruc = customerDto.getRuc();
		this.socialReason = customerDto.getSocialReason();
		this.bankAccount = customerDto.getBankAccount();
		this.registerDate = customerDto.getRegisterDate();
	}
}
