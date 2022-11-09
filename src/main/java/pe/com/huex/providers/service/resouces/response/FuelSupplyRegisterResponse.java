package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FuelSupplyRegisterResponse {

    private FuelSupplyDto fuelSupplyDto = null;

    public FuelSupplyRegisterResponse fuelSupplyRegisterResponse(FuelSupplyDto fuelSupplyDto) {
        this.fuelSupplyDto = fuelSupplyDto;
        return this;
    }
}
