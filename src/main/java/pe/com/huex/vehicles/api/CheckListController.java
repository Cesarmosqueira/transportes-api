package pe.com.huex.vehicles.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.ICheckListService;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.response.CheckListListResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListUpdateResponse;

import java.io.IOException;

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
    public ResponseDto<CheckListRegisterResponse> registerCheckList(@RequestParam(name = "file", required = false) MultipartFile file,
                                                               @RequestParam(name = "request", required = false) String request) throws Exception {
        return checkListService.registerCheckList(file, request);
    }

    @PutMapping
    public ResponseDto<CheckListUpdateResponse> updateCheckList(@RequestParam(name = "file", required = false) MultipartFile file,
                                                                @RequestParam(name = "request", required = false) String request) throws IOException {
        return checkListService.updateCheckList(file, request);
    }
}
