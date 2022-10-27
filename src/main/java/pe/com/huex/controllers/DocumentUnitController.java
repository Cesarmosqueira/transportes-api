package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.DocumentUnit;
import pe.com.huex.services.DocumentUnitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("documentUnit")
public class DocumentUnitController {

    @Autowired
    DocumentUnitService documentUnitService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<DocumentUnitListDto> listDocumentUnits() throws Exception {
        return documentUnitService.listDocumentUnits();
    }

    @GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<DocumentUnitRetrieveDto> retrieveDocumentUnit(@PathVariable Long id) throws Exception {
        return documentUnitService.retrieveDocumentUnit(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<DocumentUnitRegisterDto> registerDocumentUnit(@RequestBody DocumentUnit documentUnit) throws Exception {
        return documentUnitService.registerDocumentUnit(documentUnit);
    }

    @PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<DocumentUnitUpdateDto> updateDocumentUnit(@PathVariable Long id, @RequestBody DocumentUnit documentUnit) throws Exception {
        return documentUnitService.updateDocumentUnit(id, documentUnit);
    }
}
