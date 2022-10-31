package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class KardexFuelRegisterResponse {
    private KardexFuelDto kardexFuelDto = null;

    public KardexFuelRegisterResponse kardexFuel(KardexFuelDto kardexFuelDto) {
        this.kardexFuelDto = kardexFuelDto;
        return this;
    }
}
