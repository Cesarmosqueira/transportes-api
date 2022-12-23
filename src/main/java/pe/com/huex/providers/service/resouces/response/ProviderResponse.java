package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

@Data
@NoArgsConstructor
public class ProviderResponse {
    private ProviderDto provider = null;

    public ProviderResponse provider(ProviderDto providerDto) {
        this.provider = providerDto;
        return this;
    }
}
