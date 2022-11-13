package pe.com.huex.customer.services.resources.response;

import java.util.List;

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
public class RouteListResponse {

    private List<RouteDto> routeDtoList = null;

    public RouteListResponse routeListResponse(List<RouteDto> routeDtoList) {
        this.routeDtoList = routeDtoList;
        return this;
    }
}
