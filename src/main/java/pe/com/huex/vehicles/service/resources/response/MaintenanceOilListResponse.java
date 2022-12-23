package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

import java.util.List;

@Data
public class MaintenanceOilListResponse {
    private List<MaintenanceOilDto> maintenancesOil = null;

    public MaintenanceOilListResponse maintenanceOilList(List<MaintenanceOilDto> maintenanceOilDtoList) {
        this.maintenancesOil = maintenanceOilDtoList;
        return this;
    }
}
