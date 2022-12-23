package pe.com.huex.customer.services.resources.response;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.RouteDto;

@Data
@NoArgsConstructor
public class RouteResponse {

    private RouteDto route = null;

    public RouteResponse route(RouteDto routeDto) {
        this.route = routeDto;
        return this;
    }
}
