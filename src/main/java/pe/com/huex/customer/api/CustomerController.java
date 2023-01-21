package pe.com.huex.customer.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.customer.domain.service.ICustomerService;

import pe.com.huex.customer.services.resources.response.CustomerListResponse;
import pe.com.huex.customer.services.resources.dto.CustomerDto;
import pe.com.huex.customer.services.resources.response.CustomerResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping("customers")
public class CustomerController {
	private final ICustomerService customerService;

	public CustomerController(ICustomerService customerService) {

		this.customerService = customerService;
	}
	@GetMapping
	public ResponseDto<CustomerListResponse> listCustomer() throws Exception {
		return customerService.listCustomer();
	}

	@GetMapping(path = "{id}")
	public ResponseDto<CustomerResponse> retrieveCustomer(@PathVariable Long id) throws Exception {
		return customerService.retrieveCustomer(id);
	}

	@PostMapping
	public ResponseDto<CustomerResponse> registerCustomer(@RequestBody CustomerDto customerDto) throws Exception {
		return customerService.registerCustomer(customerDto);
	}

	@PutMapping
	public ResponseDto<CustomerResponse> updateCustomer(@RequestBody CustomerDto customerDto)
			throws Exception {
		return customerService.updateCustomer(customerDto);
	}

	@DeleteMapping(path = "{id}")
	public ResponseDto<CustomerResponse> deleteCustomer(@PathVariable Long id)
			throws Exception {
		return customerService.deleteCustomer(id);
	}
}
