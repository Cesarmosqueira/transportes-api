package pe.com.huex.employees.domain.dtos.employees;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;

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
