package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

import java.util.List;

@Data
public class TruckFleetListResponse {

    private List<TruckFleetDto> truckFleets = null;

    public TruckFleetListResponse truckFleetList(List<TruckFleetDto> truckFleetDtoList) {
        this.truckFleets = truckFleetDtoList;
        return this;
    }

}
