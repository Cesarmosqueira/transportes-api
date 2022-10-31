package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TruckFleetListResponse {

    private List<TruckFleetDto> truckFleetDtoList = null;

    public TruckFleetListResponse truckFleetList(List<TruckFleetDto> truckFleetDtoList) {
        this.truckFleetDtoList = truckFleetDtoList;
        return this;
    }

}
