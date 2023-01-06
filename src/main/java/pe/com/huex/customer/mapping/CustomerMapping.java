package pe.com.huex.customer.mapping;
import org.modelmapper.ModelMapper;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.resources.dto.CustomerDto;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapping extends ModelMapper implements Serializable {


    public CustomerMapping() {

        super();
    }

    public List<CustomerDto> modelList(List<Customer> modelList) {
        return modelList.stream().map(item -> this.map(item, CustomerDto.class))
                .collect(Collectors.toList());
    }

    public Customer model(CustomerDto customerDto) {
        return this.map(customerDto, Customer.class);
    }

    public CustomerDto modelDto(Customer customer) {
        return this.map(customer, CustomerDto.class);
    }
}
