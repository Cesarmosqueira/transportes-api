package pe.com.huex.operationsCosts.api;

import org.springframework.web.bind.annotation.*;
import pe.com.huex.operationsCosts.domain.persistence.RouteTollRepository;
import pe.com.huex.operationsCosts.domain.service.IRouteTollService;
import pe.com.huex.operationsCosts.services.resources.dto.CostRouteTollDto;
import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollListResponse;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollResponse;
import pe.com.huex.util.ResponseDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("route_tolls")
public class RouteTollController {

    private final IRouteTollService routeTollService;
    private final RouteTollRepository routeTollRepository;

    public RouteTollController(IRouteTollService routeTollService,
                               RouteTollRepository routeTollRepository) {
        this.routeTollService = routeTollService;
        this.routeTollRepository = routeTollRepository;
    }

    @GetMapping("/costRouteToll")
    public List<CostRouteTollDto> costRouteToll(@RequestParam String route, @RequestParam String configuration) throws Exception {

        List<Object[]>result=routeTollService.costTollRoute(route,configuration);

        List<CostRouteTollDto>costRouteTollDtoList=new ArrayList<>();

        for(Object[] row: result){
            CostRouteTollDto costRouteTollDto=new CostRouteTollDto();
            costRouteTollDto.setNumberToll((BigInteger) row[0]);
            costRouteTollDto.setConfiguration((String) row[1]);
            costRouteTollDto.setRouteEnd((String) row[2]);
            costRouteTollDto.setCost((Double) row[3]);
            costRouteTollDtoList.add(costRouteTollDto);
        }
        return costRouteTollDtoList;
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
