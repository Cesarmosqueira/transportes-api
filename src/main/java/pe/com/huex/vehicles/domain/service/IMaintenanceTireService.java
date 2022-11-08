package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireUpdateResponse;

public interface IMaintenanceTireService {

    ResponseDto<MaintenanceTireListResponse> listMaintenanceTires();

    ResponseDto<MaintenanceTireRetrieveResponse> retrieveMaintenanceTire(Long id);

    ResponseDto<MaintenanceTireRegisterResponse> registerMaintenanceTire(MaintenanceTireDto maintenanceTireDto);

    ResponseDto<MaintenanceTireUpdateResponse> updateMaintenanceTire(MaintenanceTireDto maintenanceTireDto);
}
