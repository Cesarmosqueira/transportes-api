package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOilListResponse {
    private List<MaintenanceOilDto> maintenanceOilDtoList = null;

    public MaintenanceOilListResponse maintenanceOilList(List<MaintenanceOilDto> maintenanceOilDtoList) {
        this.maintenanceOilDtoList = maintenanceOilDtoList;
        return this;
    }
}
