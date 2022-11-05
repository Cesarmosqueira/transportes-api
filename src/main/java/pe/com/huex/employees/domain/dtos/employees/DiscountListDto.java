package pe.com.huex.employees.domain.dtos.employees;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;

public class DiscountListDto {
	public DiscountListDto() {
	}

	private List<DiscountResponseDto> discountList = null;

	public DiscountListDto discountList(List<EmployeeDiscount> discountList) {
		this.discountList = new ArrayList<DiscountResponseDto>();
		for (EmployeeDiscount emp : discountList) {
			this.discountList.add(new DiscountResponseDto(emp));
		}
		return this;
	}

	public void setDiscountList(List<DiscountResponseDto> discountList) {
		this.discountList = discountList;
	}

	public List<DiscountResponseDto> getDiscountList() {
		return discountList;
	}
}
