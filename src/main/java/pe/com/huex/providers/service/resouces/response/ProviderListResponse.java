package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ProviderListResponse {

    private List<ProviderDto> providers = null;

    public ProviderListResponse providerList(List<ProviderDto> providerDtoList) {
        this.providers = providerDtoList;
        return this;
    }

}
