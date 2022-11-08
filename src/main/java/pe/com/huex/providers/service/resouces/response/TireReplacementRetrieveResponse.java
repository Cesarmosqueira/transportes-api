package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TireReplacementRetrieveResponse {

    private TireReplacementDto tireReplacementDto = null;

    public TireReplacementRetrieveResponse tireReplacementRetrieveResponse(TireReplacementDto tireReplacementDto) {
        this.tireReplacementDto = tireReplacementDto;
        return this;
    }
}
