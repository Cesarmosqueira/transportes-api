package pe.com.huex.customer.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerEmployeeListResponse {

    private List<CustomerEmployeeDto> customerEmployee = null;

    public CustomerEmployeeListResponse customerEmployee(List<CustomerEmployeeDto> customerEmployeeDtoList) {
        this.customerEmployee = customerEmployeeDtoList;
        return this;
    }
}
