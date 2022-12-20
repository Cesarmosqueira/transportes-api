package pe.com.huex.vehicles.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
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
    public ResponseDto<CheckListRetrieveResponse> retrieveCheckList(@PathVariable Long id) {
        return checkListService.retrieveCheckList(id);
    }

    @PostMapping
    public ResponseDto<CheckListRegisterResponse> registerCheckList(@RequestBody CheckListDto checkListDto) throws Exception {
        return checkListService.registerCheckList(checkListDto);
    }

    @PutMapping
    public ResponseDto<CheckListUpdateResponse> updateCheckList(@RequestBody CheckListDto checkListDto) throws IOException {
        return checkListService.updateCheckList(checkListDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListUpdateResponse> deleteCheckList(@PathVariable Long id) throws IOException {
        return checkListService.deleteCheckList(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto<CheckListListResponse> listCheckListsByIdTruckFleet(@PathVariable Long id) {
        return checkListService.listCheckListsByIdTruckFleet(id);
    }
}
