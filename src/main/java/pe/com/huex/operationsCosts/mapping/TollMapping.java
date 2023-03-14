package pe.com.huex.operationsCosts.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.operationsCosts.domain.entities.Toll;
import pe.com.huex.operationsCosts.services.resources.dto.TollDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TollMapping extends ModelMapper implements Serializable {

    public TollMapping() {

        super();
    }

    public List<TollDto> modelList(List<Toll> modelList) {
        return modelList.stream().map(item -> this.map(item, TollDto.class))
                .collect(Collectors.toList());
    }

    public Toll model(TollDto tollDto) {

        return this.map(tollDto, Toll.class);
    }

    public TollDto modelDto(Toll toll) {
        return this.map(toll, TollDto.class);
    }
}
