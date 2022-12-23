package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IMaintenanceOilService {

    ResponseDto<MaintenanceOilListResponse> listMaintenanceOils();

    ResponseDto<MaintenanceOilResponse> retrieveMaintenanceOil(Long id);

    ResponseDto<MaintenanceOilResponse> registerMaintenanceOil(MaintenanceOilDto maintenanceOilDto);

    ResponseDto<MaintenanceOilResponse> updateMaintenanceOil(MaintenanceOilDto maintenanceOilDto);
    ResponseDto deleteMaintenanceOil(Long id);

    ResponseDto<MaintenanceOilListResponse> listMaintenanceOilsByIdTruckFleet(Long id);
}
