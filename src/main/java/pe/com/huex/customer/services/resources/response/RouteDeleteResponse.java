package pe.com.huex.customer.services.resources.response;

import lombok.Data;

@Data
public class RouteDeleteResponse {

    private Long routeId = null;

    public RouteDeleteResponse routeDeleteResponse(Long routeId) {
        this.routeId = routeId;
        return this;
    }
}
