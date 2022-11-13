package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FuelSupplyRetrieveResponse {

    private FuelSupplyDto fuelSupplyDto = null;

    public FuelSupplyRetrieveResponse fuelSupplyRetrieveResponse(FuelSupplyDto fuelSupplyDto) {
        this.fuelSupplyDto = fuelSupplyDto;
        return this;
    }
}
