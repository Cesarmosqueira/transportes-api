package pe.com.huex.services.service.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.util.List;

@Data
@NoArgsConstructor
public class AdditionalServicesListResponse {

    private List<AdditionalServicesDto> additionalServicesDtos = null;

    public AdditionalServicesListResponse additionalServices(List<AdditionalServicesDto> additionalServicesDtos) {
        this.additionalServicesDtos = additionalServicesDtos;
        return this;
    }
}
