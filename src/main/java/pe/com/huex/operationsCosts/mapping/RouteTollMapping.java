package pe.com.huex.operationsCosts.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.operationsCosts.domain.entities.RouteToll;
import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class RouteTollMapping extends ModelMapper implements Serializable {

    public RouteTollMapping() {

        super();
    }

    public List<RouteTollDto> modelList(List<RouteToll> modelList) {

        return modelList.stream().map(item -> this.map(item, RouteTollDto.class))
                .collect(Collectors.toList());
    }

    public RouteToll model(RouteTollDto routeTollDto) {

        return this.map(routeTollDto, RouteToll.class);
    }

    public RouteTollDto modelDto(RouteToll routeToll) {

        return this.map(routeToll, RouteTollDto.class);
    }
}
