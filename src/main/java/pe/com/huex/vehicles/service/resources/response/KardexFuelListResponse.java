package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;

import java.util.List;

@Data
public class KardexFuelListResponse {
    private List<KardexFuelDto> kardexFuels = null;

    public KardexFuelListResponse kardexFuelList(List<KardexFuelDto> kardexFuelDtoList) {
        this.kardexFuels = kardexFuelDtoList;
        return this;
    }
}
