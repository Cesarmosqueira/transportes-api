package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IDiscountService;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;
import pe.com.huex.employees.services.resources.response.DiscountListResponse;
import pe.com.huex.employees.services.resources.response.DiscountResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("discounts")
public class DiscountController {

	@Autowired
	IDiscountService discountService;

	@GetMapping
	public ResponseDto<DiscountListResponse> listDiscount() {
		return discountService.listDiscounts();
	}

	@GetMapping("{id}")
	public ResponseDto<DiscountResponse> retrieveDiscount(@PathVariable Long id) {
		return discountService.retrieveDiscount(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountResponse> registerDiscount(
			@RequestBody DiscountDto discount)
			throws Exception {
		return discountService.registerDiscount(discount);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountResponse> updateDiscount(
			@RequestBody DiscountDto discountDto) throws IOException {
		return discountService.updateDiscount(discountDto);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto deleteDiscount(@PathVariable Long id) {
		return discountService.deleteDiscount(id);
	}

}
