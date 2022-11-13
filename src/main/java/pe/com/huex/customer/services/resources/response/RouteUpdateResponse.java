package pe.com.huex.customer.services.resources.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.customer.services.resources.dto.RouteDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RouteUpdateResponse {

    private RouteDto routeDto = null;

    public RouteUpdateResponse routeUpdateResponse(RouteDto routeDto) {
        this.routeDto = routeDto;
        return this;
    }
}
