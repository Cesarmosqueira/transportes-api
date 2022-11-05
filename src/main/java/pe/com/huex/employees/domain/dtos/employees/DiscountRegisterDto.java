package pe.com.huex.employees.domain.dtos.employees;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;

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
