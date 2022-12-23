package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;

@Data
public class KardexFuelResponse {
    private KardexFuelDto kardexFuel = null;

    public KardexFuelResponse kardexFuel(KardexFuelDto kardexFuelDto) {
        this.kardexFuel = kardexFuelDto;
        return this;
    }
}
