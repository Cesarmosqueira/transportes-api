package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

import java.util.List;

@Data
public class MaintenanceTireListResponse {
    private List<MaintenanceTireDto> maintenancesTire = null;

    public MaintenanceTireListResponse maintenanceTireList(List<MaintenanceTireDto> maintenanceTireDtoList) {
        this.maintenancesTire = maintenanceTireDtoList;
        return this;
    }
}
