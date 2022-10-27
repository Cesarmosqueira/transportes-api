package pe.com.huex.dto.Response;

import pe.com.huex.entities.KardexFuel;

import java.util.List;

public class KardexFuelListDto {
    
    public KardexFuelListDto() {
    }

    private List<KardexFuel> kardexFuelList = null;

    public KardexFuelListDto kardexFuelList(List<KardexFuel> kardexFuelList) {
        this.kardexFuelList = kardexFuelList;
        return this;
    }

    public void setKardexFuelList(List<KardexFuel> kardexFuelList) {
        this.kardexFuelList = kardexFuelList;
    }

    public List<KardexFuel> getKardexFuelList() {
        return kardexFuelList;
    }
}
