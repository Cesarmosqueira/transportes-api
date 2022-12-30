package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountMapping extends ModelMapper implements Serializable {

    public DiscountMapping() {
        super();
    }

    public List<DiscountDto> modelList(List<EmployeeDiscount> modelList) {
        return modelList.stream().map(item -> this.map(item, DiscountDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDiscount model(DiscountDto discountDto) {
        return this.map(discountDto, EmployeeDiscount.class);
    }

    public DiscountDto modelDto(EmployeeDiscount employeeDiscount) {
        return this.map(employeeDiscount, DiscountDto.class);
    }
}
