package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.ProviderUpdateResponse;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RuteUpdateResponse {

    private RuteDto ruteDto = null;

    public RuteUpdateResponse ruteUpdateResponse(RuteDto ruteDto) {
        this.ruteDto = ruteDto;
        return this;
    }
}
