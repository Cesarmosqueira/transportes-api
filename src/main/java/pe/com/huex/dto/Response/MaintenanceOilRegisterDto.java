package pe.com.huex.dto.Response;

import pe.com.huex.entities.MaintenanceOil;

public class MaintenanceOilRegisterDto {

    public MaintenanceOilRegisterDto() {
    }

    private MaintenanceOil maintenanceOil = null;

    public MaintenanceOilRegisterDto maintenanceOil(MaintenanceOil maintenanceOil) {
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
