package pe.com.huex.customer.services.resources.customer.dtos;

import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;

public class CustomerRegisterDto {
	private CustomerResponseDto customer = null;

	public CustomerRegisterDto() {
	}

	public CustomerRegisterDto customer(Customer customer) {
		this.customer = new CustomerResponseDto(customer);
		return this;
	}

	public CustomerResponseDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponseDto customer) {
		this.customer = customer;
	}

}
