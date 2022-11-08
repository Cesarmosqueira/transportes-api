package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TireReplacementUpdateResponse {

    private TireReplacementDto tireReplacementDto = null;

    public TireReplacementUpdateResponse tireReplacementUpdateResponse(TireReplacementDto tireReplacementDto) {
        this.tireReplacementDto = tireReplacementDto;
        return this;
    }
}
