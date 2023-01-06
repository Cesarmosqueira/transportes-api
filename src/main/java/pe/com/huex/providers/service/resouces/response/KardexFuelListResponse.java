package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.KardexFuelDto;

import java.util.List;

@Data
public class KardexFuelListResponse {
    private List<KardexFuelDto> kardexFuels = null;

    public KardexFuelListResponse kardexFuelList(List<KardexFuelDto> kardexFuelDtoList) {
        this.kardexFuels = kardexFuelDtoList;
        return this;
    }
}
