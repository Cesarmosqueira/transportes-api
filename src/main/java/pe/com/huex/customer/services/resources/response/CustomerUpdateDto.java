package pe.com.huex.customer.services.resources.response;

public class CustomerUpdateDto {
	private CustomerResponseDto customer = null;

	public CustomerUpdateDto() {
	}

	public CustomerUpdateDto customer(CustomerResponseDto customer) {
		this.customer = customer;
		return this;
	}

	public CustomerResponseDto get() {
		return customer;
	}

	public void set(CustomerResponseDto customer) {
		this.customer = customer;
	}

}
