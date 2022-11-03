package pe.com.huex.customers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.customers.domain.model.entity.Rute;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class RuteMapping extends ModelMapper implements Serializable {

    public RuteMapping() {

        super();
    }

    public List<RuteDto> modelList(List<Rute> modelList) {
        return modelList.stream().map(item -> this.map(item, RuteDto.class))
                .collect(Collectors.toList());
    }

    public Rute model(RuteDto ruteDto) {
        return this.map(ruteDto, Rute.class);
    }

    public RuteDto modelDto(Rute rute) {
        return this.map(rute, RuteDto.class);
    }
}
