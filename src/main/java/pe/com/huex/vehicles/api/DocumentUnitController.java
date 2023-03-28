package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.service.IDocumentUnitService;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.*;

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
    public ResponseDto<DocumentUnitResponse> retrieveDocumentUnit(@PathVariable Long id) {
        return documentUnitService.retrieveDocumentUnit(id);
    }

    @PostMapping
    public ResponseDto<DocumentUnitResponse> registerDocumentUnit(@RequestBody DocumentUnitDto documentUnitDto) throws Exception {
        return documentUnitService.registerDocumentUnit(documentUnitDto);
    }

    @PutMapping
    public ResponseDto<DocumentUnitResponse> updateDocumentUnit(@RequestBody DocumentUnitDto documentUnitDto) throws Exception {
        return documentUnitService.updateDocumentUnit(documentUnitDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListResponse> deleteDocumentUnit(@PathVariable Long id) {
        return documentUnitService.deleteDocumentUnit(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto listDocumentUnitsByIdTruckFleet(@PathVariable Long id) {
        return documentUnitService.listDocumentUnitsByIdTruckFleet(id);
    }

    @GetMapping(path = "expiration")
    public ResponseDto<DocumentUnitListResponse> listDocumentUnitsExpiration() {
        return documentUnitService.listDocumentUnitsExpiration();
    }

}
