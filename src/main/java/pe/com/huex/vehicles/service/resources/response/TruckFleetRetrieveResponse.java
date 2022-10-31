package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TruckFleetRetrieveResponse {

    private TruckFleetDto truckFleetDto = null;

    public TruckFleetRetrieveResponse truckFleet(TruckFleetDto truckFleetDto) {
        this.truckFleetDto = truckFleetDto;
        return this;
    }
}
