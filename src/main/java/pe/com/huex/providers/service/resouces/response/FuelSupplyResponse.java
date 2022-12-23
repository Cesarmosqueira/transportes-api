package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;


@Data
@NoArgsConstructor
public class FuelSupplyResponse {

    private FuelSupplyDto fuelSupply = null;

    public FuelSupplyResponse fuelSupply(FuelSupplyDto fuelSupplyDto) {
        this.fuelSupply = fuelSupplyDto;
        return this;
    }
}
