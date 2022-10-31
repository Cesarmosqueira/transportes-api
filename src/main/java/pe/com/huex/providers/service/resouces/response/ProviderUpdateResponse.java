package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderUpdateResponse {
    private ProviderDto providerDto = null;

    public ProviderUpdateResponse provider(ProviderDto providerDto) {
        this.providerDto = providerDto;
        return this;
    }
}
