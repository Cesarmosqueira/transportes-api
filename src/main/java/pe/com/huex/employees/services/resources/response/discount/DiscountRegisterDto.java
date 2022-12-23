package pe.com.huex.employees.services.resources.response.discount;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.services.resources.dtos.DiscountResponseDto;

public class DiscountRegisterDto {
	private DiscountResponseDto discount = null;

	public DiscountRegisterDto() {
	}

	public DiscountRegisterDto discount(EmployeeDiscount discount) {
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
