package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.KardexFuelDto;

@Data
public class KardexFuelResponse {
    private KardexFuelDto kardexFuel = null;

    public KardexFuelResponse kardexFuel(KardexFuelDto kardexFuelDto) {
        this.kardexFuel = kardexFuelDto;
        return this;
    }
}
