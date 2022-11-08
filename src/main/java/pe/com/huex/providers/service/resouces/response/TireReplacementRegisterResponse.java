package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TireReplacementRegisterResponse {

    private TireReplacementDto tireReplacementDto = null;

    public TireReplacementRegisterResponse tireReplacementRegisterResponse(TireReplacementDto tireReplacementDto) {
        this.tireReplacementDto = tireReplacementDto;
        return this;
    }
}
