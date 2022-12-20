package pe.com.huex.vehicles.domain.service;

import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitListResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitUpdateResponse;

import java.io.IOException;

public interface IDocumentUnitService {

    ResponseDto<DocumentUnitListResponse> listDocumentUnits();

    ResponseDto<DocumentUnitRetrieveResponse> retrieveDocumentUnit(Long id);

    ResponseDto<DocumentUnitListResponse> listDocumentUnitsByIdTruckFleet(Long id);

    ResponseDto<DocumentUnitRegisterResponse> registerDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException;

    ResponseDto<DocumentUnitUpdateResponse> updateDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException;

    ResponseDto deleteDocumentUnit(Long id);
}
