package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.services.domain.entities.AdditionalServices;
import pe.com.huex.services.domain.entities.ExpenseType;
import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class AdditionalServicesMapping extends ModelMapper implements Serializable {

    public AdditionalServicesMapping() {

        super();
    }

    public List<AdditionalServicesDto> modelList(List<AdditionalServices> modelList) {
        return modelList.stream().map(item -> this.map(item, AdditionalServicesDto.class))
                .collect(Collectors.toList());
    }

    public AdditionalServices model(AdditionalServicesDto additionalServicesDto) {

        return this.map(additionalServicesDto, AdditionalServices.class);
    }

    public AdditionalServicesDto modelDto(AdditionalServices additionalServices) {

        return this.map(additionalServices, AdditionalServicesDto.class);
    }
}
