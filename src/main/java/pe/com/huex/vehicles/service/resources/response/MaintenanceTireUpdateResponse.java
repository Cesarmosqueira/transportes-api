package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceTireUpdateResponse {

    private MaintenanceTireDto maintenanceTireDto = null;

    public MaintenanceTireUpdateResponse maintenanceTire(MaintenanceTireDto maintenanceTireDto) {
        this.maintenanceTireDto = maintenanceTireDto;
        return this;
    }
}
