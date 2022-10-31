package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOilUpdateResponse {

    private MaintenanceOilDto maintenanceOilDto = null;

    public MaintenanceOilUpdateResponse maintenanceOil(MaintenanceOilDto maintenanceOilDto) {
        this.maintenanceOilDto = maintenanceOilDto;
        return this;
    }
}
