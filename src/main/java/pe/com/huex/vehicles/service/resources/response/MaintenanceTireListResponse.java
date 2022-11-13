package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceTireListResponse {
    private List<MaintenanceTireDto> maintenanceTireDtoList = null;

    public MaintenanceTireListResponse maintenanceTireList(List<MaintenanceTireDto> maintenanceTireDtoList) {
        this.maintenanceTireDtoList = maintenanceTireDtoList;
        return this;
    }
}
