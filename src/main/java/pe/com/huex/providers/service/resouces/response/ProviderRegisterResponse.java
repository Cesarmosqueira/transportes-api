package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRegisterResponse {
    private ProviderDto providerDto = null;

    public ProviderRegisterResponse provider(ProviderDto providerDto) {
        this.providerDto = providerDto;
        return this;
    }

}
