package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

@Data
public class MaintenanceTireResponse {

    private MaintenanceTireDto maintenanceTire = null;

    public MaintenanceTireResponse maintenanceTire(MaintenanceTireDto maintenanceTireDto) {
        this.maintenanceTire = maintenanceTireDto;
        return this;
    }
}
