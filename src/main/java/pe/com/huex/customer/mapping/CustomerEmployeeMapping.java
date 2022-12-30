package pe.com.huex.customer.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;
import pe.com.huex.customer.services.resources.dto.RateDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerEmployeeMapping extends ModelMapper implements Serializable {

    public CustomerEmployeeMapping() {

        super();
    }

    public List<CustomerEmployeeDto> modelList(List<CustomerEmployee> modelList) {
        return modelList.stream().map(item -> this.map(item, CustomerEmployeeDto.class))
                .collect(Collectors.toList());
    }

    public CustomerEmployee model(CustomerEmployeeDto customerEmployeeDto) {
        return this.map(customerEmployeeDto, CustomerEmployee.class);
    }

    public CustomerEmployeeDto modelDto(CustomerEmployee customerEmployee) {
        return this.map(customerEmployee, CustomerEmployeeDto.class);
    }
}
