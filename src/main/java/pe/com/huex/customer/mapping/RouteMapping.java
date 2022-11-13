package pe.com.huex.customer.mapping;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import pe.com.huex.customer.domain.entities.Route;
import pe.com.huex.customer.services.resources.dto.RouteDto;

public class RouteMapping extends ModelMapper implements Serializable {

    public RouteMapping() {

        super();
    }

    public List<RouteDto> modelList(List<Route> modelList) {
        return modelList.stream().map(item -> this.map(item, RouteDto.class))
                .collect(Collectors.toList());
    }

    public Route model(RouteDto routeDto) {

        return this.map(routeDto, Route.class);
    }

    public RouteDto modelDto(Route route) {
        return this.map(route, RouteDto.class);
    }
}
