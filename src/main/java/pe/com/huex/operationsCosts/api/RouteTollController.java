package pe.com.huex.operationsCosts.api;

import org.springframework.web.bind.annotation.*;
import pe.com.huex.operationsCosts.domain.service.IRouteTollService;
import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollListResponse;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping("route_tolls")
public class RouteTollController {

    private final IRouteTollService routeTollService;

    public RouteTollController(IRouteTollService routeTollService) {
        this.routeTollService = routeTollService;
    }


    @GetMapping
    public ResponseDto<RouteTollListResponse> listRouteToll() throws Exception {
        return routeTollService.RouteTollList();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<RouteTollResponse> retrieveRouteToll(@PathVariable Long id) throws Exception {
        return routeTollService.retrieveRouteToll(id);
    }

    @PostMapping
    public ResponseDto<RouteTollResponse> registerRouteToll(@RequestBody RouteTollDto routeTollDto) throws Exception {
        return routeTollService.registerRouteToll(routeTollDto);
    }

    @PutMapping
    public ResponseDto<RouteTollResponse> updateRouteToll(@RequestBody RouteTollDto routeTollDto)
            throws Exception {
        return routeTollService.updateRouteToll(routeTollDto);
    }

    @DeleteMapping(path = "{id}")
    public ResponseDto<RouteTollResponse> deleteRouteToll(@PathVariable Long id)
            throws Exception {
        return routeTollService.deleteRouteToll(id);
    }


}
