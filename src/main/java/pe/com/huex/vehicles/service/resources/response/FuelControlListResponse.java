package pe.com.huex.vehicles.service.resources.response;

import lombok.Data;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;

import java.util.List;

@Data
public class FuelControlListResponse {

    private List<FuelControlDto> fuelControlDto = null;

    public FuelControlListResponse fuelControlList(List<FuelControlDto> fuelControlDto) {
        this.fuelControlDto = fuelControlDto;
        return this;
    }
}
