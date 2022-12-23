package pe.com.huex.customer.services.resources.response;

import java.util.List;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.RouteDto;

@Data
@NoArgsConstructor
public class RouteListResponse {

    private List<RouteDto> routes = null;

    public RouteListResponse routes(List<RouteDto> routeDtoList) {
        this.routes = routeDtoList;
        return this;
    }
}
