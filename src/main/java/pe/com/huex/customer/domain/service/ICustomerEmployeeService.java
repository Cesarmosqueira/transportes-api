package pe.com.huex.customer.domain.service;


import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;
import pe.com.huex.customer.services.resources.response.*;
import pe.com.huex.util.ResponseDto;

public interface ICustomerEmployeeService {

    ResponseDto<CustomerEmployeeListResponse> listCustomerEmployee();

    ResponseDto<CustomerEmployeeResponse> retrieveCustomerEmployee(Long id);

    ResponseDto<CustomerEmployeeResponse> registerCustomerEmployee(CustomerEmployeeDto customerEmployeeDto);

    ResponseDto<CustomerEmployeeResponse> updateCustomerEmployee(CustomerEmployeeDto customerEmployeeDto);

    ResponseDto deleteRate(Long id);

}
