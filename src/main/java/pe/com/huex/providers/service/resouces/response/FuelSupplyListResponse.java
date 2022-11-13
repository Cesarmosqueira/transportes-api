package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FuelSupplyListResponse {

    private List<FuelSupplyDto> fuelSupplyDtoList = null;

    public FuelSupplyListResponse fuelSupplyListResponse(List<FuelSupplyDto> fuelSupplyDtoList) {
        this.fuelSupplyDtoList = fuelSupplyDtoList;
        return this;
    }
}
