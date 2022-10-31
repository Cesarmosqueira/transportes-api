package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRetrieveResponse {

    private ProviderDto providerDto = null;

    public ProviderRetrieveResponse provider(ProviderDto providerDto) {
        this.providerDto = providerDto;
        return this;
    }
}
