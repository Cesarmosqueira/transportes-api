package pe.com.huex.employees.services.resources.response.discount;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.services.resources.dtos.DiscountResponseDto;

@Data
@NoArgsConstructor
public class DiscountListDto {

	private List<DiscountResponseDto> discounts = null;

	public DiscountListDto discountList(List<EmployeeDiscount> discountList) {
		this.discounts = new ArrayList<DiscountResponseDto>();
		for (EmployeeDiscount emp : discountList) {
			this.discounts.add(new DiscountResponseDto(emp));
		}
		return this;
	}
}
