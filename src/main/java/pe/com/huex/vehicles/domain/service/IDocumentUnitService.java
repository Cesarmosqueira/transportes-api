package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitListResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitResponse;

import java.io.IOException;

public interface IDocumentUnitService {

    ResponseDto<DocumentUnitListResponse> listDocumentUnits();

    ResponseDto<DocumentUnitResponse> retrieveDocumentUnit(Long id);

    ResponseDto<DocumentUnitListResponse> listDocumentUnitsByIdTruckFleet(Long id);

    ResponseDto<DocumentUnitResponse> registerDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException;

    ResponseDto<DocumentUnitResponse> updateDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException;

    ResponseDto deleteDocumentUnit(Long id);

    ResponseDto<DocumentUnitListResponse> listDocumentUnitsExpiration();
}
