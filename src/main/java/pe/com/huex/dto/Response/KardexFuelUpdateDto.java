package pe.com.huex.dto.Response;

import pe.com.huex.entities.KardexFuel;

public class KardexFuelUpdateDto {

    public KardexFuelUpdateDto() {
    }

    private KardexFuel kardexFuel = null;

    public KardexFuelUpdateDto kardexFuel(KardexFuel kardexFuel) {
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
