package pe.com.huex.customer.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;

@Data
@NoArgsConstructor
public class CustomerEmployeeResponse {

    private CustomerEmployeeDto customerEmployeeDto = null;

    public CustomerEmployeeResponse customerEmployee(CustomerEmployeeDto customerEmployeeDto) {
        this.customerEmployeeDto = customerEmployeeDto;
        return this;
    }
}
