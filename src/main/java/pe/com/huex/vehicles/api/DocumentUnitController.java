package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.IDocumentUnitService;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehicle/documentUnit", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentUnitController {

    @Autowired
    IDocumentUnitService documentUnitService;

    @GetMapping
    public ResponseDto<DocumentUnitListResponse> listDocumentUnits() {
        return documentUnitService.listDocumentUnits();
    }

    @GetMapping("{id}")
    public ResponseDto<DocumentUnitRetrieveResponse> retrieveDocumentUnit(@PathVariable Long id) {
        return documentUnitService.retrieveDocumentUnit(id);
    }

    @PostMapping
    public ResponseDto<DocumentUnitRegisterResponse> registerDocumentUnit(@RequestBody DocumentUnitDto documentUnitDto) throws Exception {
        return documentUnitService.registerDocumentUnit(documentUnitDto);
    }

    @PutMapping
    public ResponseDto<DocumentUnitUpdateResponse> updateDocumentUnit(@RequestBody DocumentUnitDto documentUnitDto) throws Exception {
        return documentUnitService.updateDocumentUnit(documentUnitDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListUpdateResponse> deleteDocumentUnit(@PathVariable Long id) {
        return documentUnitService.deleteDocumentUnit(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto<DocumentUnitListResponse> listDocumentUnitsByIdTruckFleet(@PathVariable Long id) {
        return documentUnitService.listDocumentUnitsByIdTruckFleet(id);
    }
}
