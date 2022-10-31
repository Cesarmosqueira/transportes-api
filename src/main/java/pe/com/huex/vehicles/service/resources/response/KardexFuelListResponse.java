package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class KardexFuelListResponse {
    private List<KardexFuelDto> kardexFuelDtoList = null;

    public KardexFuelListResponse kardexFuelList(List<KardexFuelDto> kardexFuelDtoList) {
        this.kardexFuelDtoList = kardexFuelDtoList;
        return this;
    }
}
