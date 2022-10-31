package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilUpdateResponse;

public interface IMaintenanceOilService {

    ResponseDto<MaintenanceOilListResponse> listMaintenanceOils();

    ResponseDto<MaintenanceOilRetrieveResponse> retrieveMaintenanceOil(Long id);

    ResponseDto<MaintenanceOilRegisterResponse> registerMaintenanceOil(MaintenanceOilDto maintenanceOilDto);

    ResponseDto<MaintenanceOilUpdateResponse> updateMaintenanceOil(MaintenanceOilDto maintenanceOilDto);
}
