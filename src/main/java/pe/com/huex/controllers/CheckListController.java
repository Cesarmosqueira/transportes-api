package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.CheckList;
import pe.com.huex.services.CheckListService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("checkList")
public class CheckListController {
    @Autowired
    CheckListService checkListService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<CheckListListDto> listCheckLists() throws Exception {
        return checkListService.listCheckLists();
    }

    @GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<CheckListRetrieveDto> retrieveCheckList(@PathVariable Long id) throws Exception {
        return checkListService.retrieveCheckList(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<CheckListRegisterDto> registerCheckList(@RequestParam(name = "file", required = false) MultipartFile file,
                                                               @RequestParam(name = "request", required = false) String request) throws Exception {
        return checkListService.registerCheckList(file, request);
    }

    @PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<CheckListUpdateDto> updateCheckList(@PathVariable Long id, @RequestBody CheckList checkList) throws Exception {
        return checkListService.updateCheckList(id, checkList);
    }
}
