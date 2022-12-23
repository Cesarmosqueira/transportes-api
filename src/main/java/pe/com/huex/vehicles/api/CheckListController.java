package pe.com.huex.vehicles.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.service.ICheckListService;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.response.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehicle/checkList", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckListController {

    private final ICheckListService checkListService;

    public CheckListController(ICheckListService checkListService) {
        this.checkListService = checkListService;
    }

    @GetMapping
    public ResponseDto<CheckListListResponse> listCheckLists() {
        return checkListService.listCheckLists();
    }

    @GetMapping("{id}")
    public ResponseDto<CheckListResponse> retrieveCheckList(@PathVariable Long id) {
        return checkListService.retrieveCheckList(id);
    }

    @PostMapping
    public ResponseDto<CheckListResponse> registerCheckList(@RequestBody CheckListDto checkListDto) throws Exception {
        return checkListService.registerCheckList(checkListDto);
    }

    @PutMapping
    public ResponseDto<CheckListResponse> updateCheckList(@RequestBody CheckListDto checkListDto) throws IOException {
        return checkListService.updateCheckList(checkListDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListResponse> deleteCheckList(@PathVariable Long id) throws IOException {
        return checkListService.deleteCheckList(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto listCheckListsByIdTruckFleet(@PathVariable Long id) {
        return checkListService.listCheckListsByIdTruckFleet(id);
    }
}
