package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceTireRegisterResponse {
    private MaintenanceTireDto maintenanceTireDto = null;

    public MaintenanceTireRegisterResponse maintenanceTire(MaintenanceTireDto maintenanceTireDto) {
        this.maintenanceTireDto = maintenanceTireDto;
        return this;
    }
}
