package pe.com.huex.employees.services.resources.response.discount;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.services.resources.dtos.DiscountResponseDto;

public class DiscountDeleteDto {
	private DiscountResponseDto discount = null;

	public DiscountDeleteDto() {
	}

	public DiscountDeleteDto discount(EmployeeDiscount discount) {
		this.discount = new DiscountResponseDto(discount);
		return this;
	}

	public DiscountResponseDto getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountResponseDto discount) {
		this.discount = discount;
	}
}
