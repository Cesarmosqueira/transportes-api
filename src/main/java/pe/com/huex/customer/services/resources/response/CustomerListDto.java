package pe.com.huex.customer.services.resources.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.domain.entities.Customer;

@Data
@NoArgsConstructor
public class CustomerListDto {
	private List<CustomerResponseDto> customers = null;

	public CustomerListDto customerList(List<Customer> customerList) {
		this.customers = new ArrayList<>();
		for (Customer emp : customerList) {
			this.customers.add(new CustomerResponseDto(emp));
		}
		return this;
	}
}
