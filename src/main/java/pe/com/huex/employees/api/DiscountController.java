package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.employees.domain.dtos.employees.DiscountDeleteDto;
import pe.com.huex.employees.domain.dtos.employees.DiscountListDto;
import pe.com.huex.employees.domain.dtos.employees.DiscountRegisterDto;
import pe.com.huex.employees.domain.dtos.employees.DiscountResponseDto;
import pe.com.huex.employees.services.DiscountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("discounts")
public class DiscountController {

	@Autowired
	DiscountService discountService;

	// Get all
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountListDto> retrieveEmployeesDiscount() throws Exception {
		return discountService.listDiscounts();
	}

	// Get by employee
	@GetMapping(path = "{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountListDto> retrieveDiscountsByEmployee(@PathVariable Long employeeId) throws Exception {
		return discountService.listDiscountsByEmployee(employeeId);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountRegisterDto> registerEmployeesDiscount(
			@RequestBody DiscountResponseDto discount)
			throws Exception {
		return discountService.registerDiscounts(discount);
	}

	@PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountRegisterDto> updateEmployeesDiscount(@PathVariable Long id,
			@RequestBody DiscountResponseDto discount)
			throws Exception {
		return discountService.updateDiscounts(id, discount);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<DiscountDeleteDto> deleteDiscount(@PathVariable Long id)
			throws Exception {
		return discountService.deleteDiscounts(id);
	}
}
