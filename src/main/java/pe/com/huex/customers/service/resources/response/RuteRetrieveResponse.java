package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.ProviderRetrieveResponse;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RuteRetrieveResponse {

    private RuteDto ruteDto = null;

    public RuteRetrieveResponse ruteRetrieveResponse(RuteDto ruteDto) {
        this.ruteDto = ruteDto;
        return this;
    }
}
