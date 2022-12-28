package pe.com.huex.customer.services.resources.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDeleteDto {

	private Long customer_id;

	public CustomerDeleteDto() {
	}

	public CustomerDeleteDto customer(Long customer_id) {
		this.customer_id = customer_id;
		return this;
	}

}
