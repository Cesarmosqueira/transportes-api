package pe.com.huex.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.customer.domain.service.IRouteService;
import pe.com.huex.customer.services.resources.dto.RouteDto;
import pe.com.huex.customer.services.resources.response.RouteDeleteResponse;
import pe.com.huex.customer.services.resources.response.RouteListResponse;
import pe.com.huex.customer.services.resources.response.RouteResponse;
import pe.com.huex.util.ResponseDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "routes")
public class RouteController {

    @Autowired
    IRouteService routeService;

    @GetMapping
    public ResponseDto<RouteListResponse> listRoute() throws Exception {
        return routeService.listRoute();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<RouteResponse> retrieveRoute(@PathVariable Long id) throws Exception {
        return routeService.retrieveRoute(id);
    }

    @PostMapping
    public ResponseDto<RouteResponse> registerRoute(@RequestBody RouteDto routeDto) throws Exception {
        return routeService.registerRoute(routeDto);
    }

    @PutMapping
    public ResponseDto<RouteResponse> updateRoute(@RequestBody RouteDto routeDto)
            throws Exception {
        return routeService.updateRoute(routeDto);
    }

    @DeleteMapping(path = "{id}")
    public ResponseDto<RouteDeleteResponse> deleteRoute(@PathVariable Long id)
            throws Exception {
        return routeService.deleteRoute(id);
    }

}
