package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

import java.util.List;

@Data
@NoArgsConstructor
public class TireReplacementListResponse {

    private List<TireReplacementDto> tiresReplacement = null;

    public TireReplacementListResponse tireReplacementListResponse(List<TireReplacementDto> tireReplacementDtoList) {
        this.tiresReplacement = tireReplacementDtoList;
        return this;
    }
}
