package pe.com.huex.dto.Response;

import pe.com.huex.entities.TruckFleet;

public class TruckFleetUpdateDto {

    public TruckFleetUpdateDto() {
    }

    private TruckFleet truckFleet = null;

    public TruckFleetUpdateDto truckFleet(TruckFleet truckFleet) {
        this.truckFleet = truckFleet;
        return this;
    }

    public void setTruckFleet(TruckFleet truckFleet) {
        this.truckFleet = truckFleet;
    }

    public TruckFleet getTruckFleet() {
        return truckFleet;
    }
}
