package pe.com.huex.dto.Response;

import pe.com.huex.entities.KardexFuel;

public class KardexFuelRetrieveDto {
    
    public KardexFuelRetrieveDto() {
    }

    private KardexFuel kardexFuel = null;

    public KardexFuelRetrieveDto kardexFuel(KardexFuel kardexFuel) {
        this.kardexFuel = kardexFuel;
        return this;
    }

    public void setKardexFuel(KardexFuel kardexFuel) {
        this.kardexFuel = kardexFuel;
    }

    public KardexFuel getKardexFuel() {
        return kardexFuel;
    }
}
