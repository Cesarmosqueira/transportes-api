package pe.com.huex.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.huex.customer.domain.service.ICustomerEmployeeService;
import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;
import pe.com.huex.customer.services.resources.response.*;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping(value = "customer_employee")
public class CustomerEmployeeController {

    @Autowired
    ICustomerEmployeeService customerEmployeeService;

    @GetMapping
    public ResponseDto<CustomerEmployeeListResponse> listCustomerEmployee() throws Exception {
        return customerEmployeeService.listCustomerEmployee();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<CustomerEmployeeResponse> retrieveCustomerEmployee(@PathVariable Long id) throws Exception {
        return customerEmployeeService.retrieveCustomerEmployee(id);
    }

    @PostMapping
    public ResponseDto<CustomerEmployeeResponse> registerCustomerEmployee(@RequestBody CustomerEmployeeDto customerEmployeeDto) throws Exception {
        return customerEmployeeService.registerCustomerEmployee(customerEmployeeDto);
    }

    @PutMapping
    public ResponseDto<CustomerEmployeeResponse> updateCustomerEmployee(@RequestBody CustomerEmployeeDto customerEmployeeDto)
            throws Exception {
        return customerEmployeeService.updateCustomerEmployee(customerEmployeeDto);
    }

    @DeleteMapping(path = "{id}")
    public ResponseDto<CustomerEmployeeResponse> deleteCustomerEmployee(@PathVariable Long id)
            throws Exception {
        return customerEmployeeService.deleteCustomerEmployee(id);
    }
}
