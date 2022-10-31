package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOilRetrieveResponse {
    private MaintenanceOilDto maintenanceOilDto = null;

    public MaintenanceOilRetrieveResponse maintenanceOil(MaintenanceOilDto maintenanceOilDto) {
        this.maintenanceOilDto = maintenanceOilDto;
        return this;
    }
}
