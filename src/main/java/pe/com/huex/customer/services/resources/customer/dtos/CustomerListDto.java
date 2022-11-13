package pe.com.huex.customer.services.resources.customer.dtos;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;

public class CustomerListDto {
	public CustomerListDto() {
	}

	private List<CustomerResponseDto> customerList = null;

	public CustomerListDto customerList(List<Customer> customerList) {
		this.customerList = new ArrayList<CustomerResponseDto>();
		for (Customer emp : customerList) {
			this.customerList.add(new CustomerResponseDto(emp));
		}
		return this;
	}

	public void setCustomerList(List<CustomerResponseDto> customerList) {
		this.customerList = customerList;
	}

	public List<CustomerResponseDto> getCustomerList() {
		return customerList;
	}
}
