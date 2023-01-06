package pe.com.huex.customer.domain.service;
import pe.com.huex.customer.services.resources.dto.CustomerDto;
import pe.com.huex.customer.services.resources.response.CustomerListResponse;
import pe.com.huex.customer.services.resources.response.CustomerResponse;
import pe.com.huex.util.ResponseDto;

public interface ICustomerService {

    ResponseDto<CustomerListResponse> listCustomer();

    ResponseDto<CustomerResponse> retrieveCustomer(Long id);

    ResponseDto<CustomerResponse> registerCustomer(CustomerDto customerDto);

    ResponseDto<CustomerResponse> updateCustomer(CustomerDto customerDto);

    ResponseDto deleteCustomer(Long id);
}
