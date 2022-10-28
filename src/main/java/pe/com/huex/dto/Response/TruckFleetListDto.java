package pe.com.huex.dto.Response;

import pe.com.huex.entities.TruckFleet;

import java.util.List;

public class TruckFleetListDto {
    
    public TruckFleetListDto() {
    }

    private List<TruckFleet> truckFleetList = null;

    public TruckFleetListDto TruckFleetList(List<TruckFleet> truckFleetList) {
        this.truckFleetList = truckFleetList;
        return this;
    }

    public void setTruckFleetList(List<TruckFleet> truckFleetList) {
        this.truckFleetList = truckFleetList;
    }

    public List<TruckFleet> getTruckFleetList() {
        return truckFleetList;
    }
}
