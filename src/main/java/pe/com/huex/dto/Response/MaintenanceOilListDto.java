package pe.com.huex.dto.Response;

import pe.com.huex.entities.MaintenanceOil;

import java.util.List;

public class MaintenanceOilListDto {
    
    public MaintenanceOilListDto() {
    }

    private List<MaintenanceOil> maintenanceOilList = null;

    public MaintenanceOilListDto maintenanceOilList(List<MaintenanceOil> maintenanceOilList) {
        this.maintenanceOilList = maintenanceOilList;
        return this;
    }

    public void setMaintenanceOilList(List<MaintenanceOil> MaintenanceOilList) {
        this.maintenanceOilList = MaintenanceOilList;
    }

    public List<MaintenanceOil> getMaintenanceOilList() {
        return maintenanceOilList;
    }
}
