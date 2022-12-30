package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;

@Data
public class DiscountResponse {
	private DiscountDto discount = null;
	public DiscountResponse discount(DiscountDto discount) {
		this.discount = discount;
		return this;
	}
}
