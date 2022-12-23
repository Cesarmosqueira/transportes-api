package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

@Data
@NoArgsConstructor
public class TireReplacementResponse {

    private TireReplacementDto tireReplacement = null;

    public TireReplacementResponse tireReplacement(TireReplacementDto tireReplacementDto) {
        this.tireReplacement = tireReplacementDto;
        return this;
    }
}
