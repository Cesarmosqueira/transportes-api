package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;

import java.util.List;

@Data
@NoArgsConstructor
public class DiscountListResponse {

	private List<DiscountDto> discounts = null;

	public DiscountListResponse discounts(List<DiscountDto> discountList) {
		this.discounts = discountList;
		return this;
	}
}
