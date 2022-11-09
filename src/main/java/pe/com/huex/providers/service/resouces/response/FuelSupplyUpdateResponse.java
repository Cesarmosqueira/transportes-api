package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FuelSupplyUpdateResponse {

    private FuelSupplyDto fuelSupplyDto = null;

    public FuelSupplyUpdateResponse fuelSupplyUpdateResponse(FuelSupplyDto fuelSupplyDto) {
        this.fuelSupplyDto = fuelSupplyDto;
        return this;
    }
}
