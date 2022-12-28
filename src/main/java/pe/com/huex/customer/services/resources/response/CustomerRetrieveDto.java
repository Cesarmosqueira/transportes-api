package pe.com.huex.customer.services.resources.response;

import pe.com.huex.customer.domain.entities.Customer;

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
