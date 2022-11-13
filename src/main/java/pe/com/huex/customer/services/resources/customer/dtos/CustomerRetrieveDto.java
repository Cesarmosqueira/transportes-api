package pe.com.huex.customer.services.resources.customer.dtos;

import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;

public class CustomerRetrieveDto {

	public CustomerRetrieveDto() {
	}

	private CustomerResponseDto customer = null;

	public CustomerRetrieveDto customer(Customer customer) {
		CustomerResponseDto customerDto = new CustomerResponseDto(customer);
		this.customer = customerDto;
		return this;
	}

	public void setCustomer(CustomerResponseDto customer) {
		this.customer = customer;
	}

	public CustomerResponseDto getCustomer() {
		return customer;
	}
}
