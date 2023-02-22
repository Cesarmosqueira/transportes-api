package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.entities.ProviderDiscount;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProviderDiscountMapping extends ModelMapper implements Serializable {


    public ProviderDiscountMapping() {
        super();
    }

    public List<ProviderDiscountDto> modelList(List<ProviderDiscount> modelList) {
        return modelList.stream().map(item -> this.map(item, ProviderDiscountDto.class))
                .collect(Collectors.toList());
    }

    public ProviderDiscount model(ProviderDiscountDto providerDiscountDto) {
        return this.map(providerDiscountDto, ProviderDiscount.class);
    }

    public ProviderDiscountDto modelDto(ProviderDiscount providerDiscount) {
        return this.map(providerDiscount, ProviderDiscountDto.class);
    }
}
