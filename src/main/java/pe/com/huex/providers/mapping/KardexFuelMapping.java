package pe.com.huex.providers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.providers.domain.model.entity.KardexFuel;
import pe.com.huex.providers.domain.model.entity.KardexFuelPojo;
import pe.com.huex.providers.service.resouces.dto.KardexFuelDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class KardexFuelMapping extends ModelMapper implements Serializable {

    public KardexFuelMapping() { super(); }

    public List<KardexFuelDto> modelList(List<KardexFuel> modelList) {
        return modelList.stream().map(item -> this.map(item, KardexFuelDto.class))
                .collect(Collectors.toList());
    }

    public List<KardexFuelDto> modelListPojo(List<KardexFuelPojo> modelList) {
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
