package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ServiceIncidentsRegisterResponse {

    private ServiceIncidentsDto serviceIncidentsDto = null;

    public ServiceIncidentsRegisterResponse serviceIncidentsRegisterResponse(ServiceIncidentsDto serviceIncidentsDto) {
        this.serviceIncidentsDto = serviceIncidentsDto;
        return this;
    }


}
