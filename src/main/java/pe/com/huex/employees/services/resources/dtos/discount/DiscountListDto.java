package pe.com.huex.employees.services.resources.dtos.discount;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.services.resources.response.DiscountResponseDto;

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
