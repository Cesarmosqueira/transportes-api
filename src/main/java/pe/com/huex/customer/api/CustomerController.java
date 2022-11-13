package pe.com.huex.customer.api;

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

import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.CustomerService;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerDeleteDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerListDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerRegisterDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerRetrieveDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerUpdateDto;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;
import pe.com.huex.dto.Response.ResponseDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<CustomerListDto> listCustomers() throws Exception {
		return customerService.listCustomers();
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<CustomerRetrieveDto> retrieveCustomers(@PathVariable Long id) throws Exception {
		return customerService.retrieveCustomers(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<CustomerRegisterDto> registerCustomers(@RequestBody CustomerResponseDto customer)
			throws Exception {
		return customerService.registerCustomers(customer);
	}

	@PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<CustomerUpdateDto> updateCustomers(@PathVariable Long id,
			@RequestBody CustomerResponseDto customer)
			throws Exception {
		return customerService.updateCustomers(id, customer);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<CustomerDeleteDto> deleteCustomer(@PathVariable Long id)
			throws Exception {
		return customerService.deleteCustomers(id);
	}
}
