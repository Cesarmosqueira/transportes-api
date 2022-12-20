package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IMaintenanceTireService {

    ResponseDto<MaintenanceTireListResponse> listMaintenanceTires();

    ResponseDto<MaintenanceTireRetrieveResponse> retrieveMaintenanceTire(Long id);

    ResponseDto<MaintenanceTireRegisterResponse> registerMaintenanceTire(MaintenanceTireDto maintenanceTireDto);

    ResponseDto<MaintenanceTireUpdateResponse> updateMaintenanceTire(MaintenanceTireDto maintenanceTireDto);

    ResponseDto<MaintenanceTireListResponse> listMaintenanceTiresByIdTruckFleet(Long id);
}
