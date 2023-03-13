package pe.com.huex.vehicles.service.resources.response;

import lombok.Data;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;


@Data
public class FuelControlResponse {

    private FuelControlDto fuelControlDto = null;

    public FuelControlResponse fuelControl(FuelControlDto fuelControlDto) {
        this.fuelControlDto = fuelControlDto;
        return this;
    }

}
