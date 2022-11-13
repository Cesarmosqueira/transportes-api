package pe.com.huex.customer.domain.service;

import pe.com.huex.customer.services.resources.dto.RouteDto;
import pe.com.huex.customer.services.resources.response.RouteDeleteResponse;
import pe.com.huex.customer.services.resources.response.RouteListResponse;
import pe.com.huex.customer.services.resources.response.RouteRegisterResponse;
import pe.com.huex.customer.services.resources.response.RouteRetrieveResponse;
import pe.com.huex.customer.services.resources.response.RouteUpdateResponse;
import pe.com.huex.dto.Response.ResponseDto;

public interface IRouteService {

    ResponseDto<RouteListResponse> listRoute();

    ResponseDto<RouteRetrieveResponse> retrieveRoute(Long id);

    ResponseDto<RouteRegisterResponse> registerRoute(RouteDto routeDto);

    ResponseDto<RouteUpdateResponse> updateRoute(RouteDto routeDto);

    ResponseDto<RouteDeleteResponse> deleteRoute(Long id);

}
