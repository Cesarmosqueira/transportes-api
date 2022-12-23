package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

@Data
public class TruckFleetResponse {
    private TruckFleetDto truckFleet = null;

    public TruckFleetResponse truckFleet(TruckFleetDto truckFleetDto) {
        this.truckFleet = truckFleetDto;
        return this;
    }
}
