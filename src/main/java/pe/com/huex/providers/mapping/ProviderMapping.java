package pe.com.huex.providers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProviderMapping extends ModelMapper implements Serializable {

    public ProviderMapping() {
        super();
    }

    public List<ProviderDto> modelList(List<Provider> modelList) {
        return modelList.stream().map(item -> this.map(item, ProviderDto.class))
                .collect(Collectors.toList());
    }

    public Provider model(ProviderDto providerDto) {
        return this.map(providerDto, Provider.class);
    }

    public ProviderDto modelDto(Provider provider) {
        return this.map(provider, ProviderDto.class);
    }
}
