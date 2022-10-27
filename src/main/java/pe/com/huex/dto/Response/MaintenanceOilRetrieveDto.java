package pe.com.huex.dto.Response;

import pe.com.huex.entities.MaintenanceOil;

public class MaintenanceOilRetrieveDto {
    
    public MaintenanceOilRetrieveDto() {
    }

    private MaintenanceOil maintenanceOil = null;

    public MaintenanceOilRetrieveDto maintenanceOil(MaintenanceOil maintenanceOil) {
        this.maintenanceOil = maintenanceOil;
        return this;
    }

    public void setMaintenanceOil(MaintenanceOil maintenanceOil) {
        this.maintenanceOil = maintenanceOil;
    }

    public MaintenanceOil getMaintenanceOil() {
        return maintenanceOil;
    }
}
