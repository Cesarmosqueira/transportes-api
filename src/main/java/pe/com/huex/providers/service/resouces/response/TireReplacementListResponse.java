package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TireReplacementListResponse {

    private List<TireReplacementDto> tireReplacementDtoList = null;

    public TireReplacementListResponse tireReplacementListResponse(List<TireReplacementDto> tireReplacementDtoList) {
        this.tireReplacementDtoList = tireReplacementDtoList;
        return this;
    }
}
