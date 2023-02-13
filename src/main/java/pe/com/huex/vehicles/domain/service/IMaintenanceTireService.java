package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IMaintenanceTireService {

    ResponseDto<MaintenanceTireListResponse> listMaintenanceTires();

    ResponseDto<MaintenanceTireResponse> retrieveMaintenanceTire(Long id);

    ResponseDto<MaintenanceTireResponse> registerMaintenanceTire(MaintenanceTireDto maintenanceTireDto);

    ResponseDto<MaintenanceTireResponse> updateMaintenanceTire(MaintenanceTireDto maintenanceTireDto);

    ResponseDto<MaintenanceTireListResponse> listMaintenanceTiresByIdTruckFleet(Long id);

    ResponseDto deleteMaintenanceTire(Long id);
}
