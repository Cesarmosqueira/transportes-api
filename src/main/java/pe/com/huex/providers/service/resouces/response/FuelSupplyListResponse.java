package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;

import java.util.List;

@Data
@NoArgsConstructor
public class FuelSupplyListResponse {

    private List<FuelSupplyDto> fuelsSupply = null;

    public FuelSupplyListResponse fuelSupplyListResponse(List<FuelSupplyDto> fuelSupplyDtoList) {
        this.fuelsSupply = fuelSupplyDtoList;
        return this;
    }
}
