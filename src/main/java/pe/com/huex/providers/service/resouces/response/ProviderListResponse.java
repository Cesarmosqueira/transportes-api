package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderListResponse {

    private List<ProviderDto> providerDtoList = null;

    public ProviderListResponse providerList(List<ProviderDto> providerDtoList) {
        this.providerDtoList = providerDtoList;
        return this;
    }

}
