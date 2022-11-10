package pe.com.huex.customer.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;
import pe.com.huex.entities.Rate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 16)
	private String ruc;

	@Column(nullable = false, length = 32)
	private String socialReason;

	@Column(nullable = false, length = 32)
	private String bankAccount;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date registerDate;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerEmployee> employees = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Rate> rates = new ArrayList<>();

	public Customer(CustomerResponseDto customerResponseDto) {
		this.ruc = customerResponseDto.getRuc();
		this.socialReason = customerResponseDto.getSocialReason();
		this.bankAccount = customerResponseDto.getBankAccount();
		this.registerDate = customerResponseDto.getRegisterDate();
	}
}
