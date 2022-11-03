package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetRegisterResponse;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RuteRegisterResponse {

    private RuteDto ruteDto = null;

    public RuteRegisterResponse ruteRegisterResponse(RuteDto ruteDto) {
        this.ruteDto = ruteDto;
        return this;
    }
}
