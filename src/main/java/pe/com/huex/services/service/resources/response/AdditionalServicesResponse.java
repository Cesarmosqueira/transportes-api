package pe.com.huex.services.service.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;

@Data
@NoArgsConstructor
public class AdditionalServicesResponse {

    private AdditionalServicesDto additionalServicesDto = null;

    public AdditionalServicesResponse additionalServices(AdditionalServicesDto additionalServicesDto) {
        this.additionalServicesDto = additionalServicesDto;
        return this;
    }
}
