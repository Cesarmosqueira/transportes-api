package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ImplementMapping extends ModelMapper implements Serializable {

    public ImplementMapping() {
        super();
    }

    public List<ImplementDto> modelList(List<Implement> modelList) {
        return modelList.stream().map(item -> this.map(item, ImplementDto.class))
                .collect(Collectors.toList());
    }

    public Implement model(ImplementDto implementDto) {
        return this.map(implementDto, Implement.class);
    }

    public ImplementDto modelDto(Implement implement) {
        return this.map(implement, ImplementDto.class);
    }
}
