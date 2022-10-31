package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.model.entity.KardexFuel;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class KardexFuelMapping extends ModelMapper implements Serializable {

    public KardexFuelMapping() { super(); }

    public List<KardexFuelDto> modelList(List<KardexFuel> modelList) {
        return modelList.stream().map(item -> this.map(item, KardexFuelDto.class))
                .collect(Collectors.toList());
    }

    public KardexFuel model(KardexFuelDto modelDto) {
        return this.map(modelDto, KardexFuel.class);
    }

    public KardexFuelDto modelDto(KardexFuel model) {
        return this.map(model, KardexFuelDto.class);
    }
}
