package pe.com.huex.customer.domain.service;

import pe.com.huex.customer.services.resources.dto.RouteDto;
import pe.com.huex.customer.services.resources.response.RouteDeleteResponse;
import pe.com.huex.customer.services.resources.response.RouteListResponse;
import pe.com.huex.customer.services.resources.response.RouteResponse;
import pe.com.huex.util.ResponseDto;

public interface IRouteService {

    ResponseDto<RouteListResponse> listRoute();

    ResponseDto<RouteResponse> retrieveRoute(Long id);

    ResponseDto<RouteResponse> registerRoute(RouteDto routeDto);

    ResponseDto<RouteResponse> updateRoute(RouteDto routeDto);

    ResponseDto<RouteDeleteResponse> deleteRoute(Long id);

}
