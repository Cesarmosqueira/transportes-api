package pe.com.huex.operationsCosts.domain.service;

import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollListResponse;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollResponse;
import pe.com.huex.util.ResponseDto;

import java.util.List;

public interface IRouteTollService {

    ResponseDto<RouteTollListResponse> RouteTollList();

    ResponseDto<RouteTollResponse> retrieveRouteToll(Long id);

    ResponseDto<RouteTollResponse> registerRouteToll(RouteTollDto routeTollDto);
    ResponseDto<RouteTollResponse> updateRouteToll(RouteTollDto routeTollDto);
    ResponseDto deleteRouteToll(Long id);

    List<Object[]>costTollRoute(String route,String configuration);

}
