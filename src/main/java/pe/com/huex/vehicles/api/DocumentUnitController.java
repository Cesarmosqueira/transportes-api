package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.IDocumentUnitService;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitListResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitUpdateResponse;

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
    public ResponseDto<DocumentUnitRegisterResponse> registerDocumentUnit(@RequestParam(name = "photoTechnicalReview", required = false) MultipartFile photoTechnicalReview,
                                                                          @RequestParam(name = "photoSoat", required = false) MultipartFile photoSoat,
                                                                          @RequestParam(name = "photoMtc", required = false) MultipartFile photoMtc,
                                                                          @RequestParam(name = "photoPolicy", required = false) MultipartFile photoPolicy,
                                                                          @RequestParam(name = "request", required = false) String request) throws Exception {
        return documentUnitService.registerDocumentUnit(photoTechnicalReview, photoSoat, photoMtc, photoPolicy, request);
    }

    @PutMapping
    public ResponseDto<DocumentUnitUpdateResponse> updateDocumentUnit(@RequestParam(name = "photoTechnicalReview", required = false) MultipartFile photoTechnicalReview,
                                                                      @RequestParam(name = "photoSoat", required = false) MultipartFile photoSoat,
                                                                      @RequestParam(name = "photoMtc", required = false) MultipartFile photoMtc,
                                                                      @RequestParam(name = "photoPolicy", required = false) MultipartFile photoPolicy,
                                                                      @RequestParam(name = "request", required = false) String request) throws Exception {
        return documentUnitService.updateDocumentUnit(photoTechnicalReview, photoSoat, photoMtc, photoPolicy, request);
    }
}
