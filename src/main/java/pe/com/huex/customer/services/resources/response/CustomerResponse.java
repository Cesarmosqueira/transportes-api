package pe.com.huex.customer.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.services.resources.dto.CustomerDto;

@Data
@NoArgsConstructor
public class CustomerResponse {

    private CustomerDto customerDto = null;

    public CustomerResponse customer(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

}
