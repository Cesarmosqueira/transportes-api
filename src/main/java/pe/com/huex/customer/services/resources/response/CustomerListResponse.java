package pe.com.huex.customer.services.resources.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.services.resources.dto.CustomerDto;

@Data
@NoArgsConstructor
public class CustomerListResponse {
	private List<CustomerDto> customer = null;

	public CustomerListResponse customer(List<CustomerDto> customerDtoList) {
		this.customer = customerDtoList;
		return this;
	}
}
