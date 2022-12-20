package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IMaintenanceOilService {

    ResponseDto<MaintenanceOilListResponse> listMaintenanceOils();

    ResponseDto<MaintenanceOilRetrieveResponse> retrieveMaintenanceOil(Long id);

    ResponseDto<MaintenanceOilRegisterResponse> registerMaintenanceOil(MaintenanceOilDto maintenanceOilDto);

    ResponseDto<MaintenanceOilUpdateResponse> updateMaintenanceOil(MaintenanceOilDto maintenanceOilDto);
    ResponseDto deleteMaintenanceOil(Long id);

    ResponseDto<MaintenanceOilListResponse> listMaintenanceOilsByIdTruckFleet(Long id);
}
