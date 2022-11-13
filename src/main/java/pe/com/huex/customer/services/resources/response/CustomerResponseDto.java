package pe.com.huex.customer.services.resources.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.domain.entities.Customer;

@Data
@NoArgsConstructor
public class CustomerResponseDto {
	private Long id;

	private String ruc;

	private String socialReason;

	private String bankAccount;

	private Date registerDate;

	public CustomerResponseDto(Customer customer) {
		this.id = customer.getId();
		this.ruc = customer.getRuc();
		this.socialReason = customer.getSocialReason();
		this.bankAccount = customer.getBankAccount();
		this.registerDate = customer.getRegisterDate();
	}
}
