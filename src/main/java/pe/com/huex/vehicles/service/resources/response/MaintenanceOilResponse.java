package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

@Data
public class MaintenanceOilResponse {

    private MaintenanceOilDto maintenanceOil = null;

    public MaintenanceOilResponse maintenanceOil(MaintenanceOilDto maintenanceOilDto) {
        this.maintenanceOil = maintenanceOilDto;
        return this;
    }
}
