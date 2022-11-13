package pe.com.huex.providers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.providers.domain.model.entity.TireReplacement;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class FuelSupplyMapping extends ModelMapper implements Serializable {

    public FuelSupplyMapping() {
        super();
    }

    public List<FuelSupplyDto> modelList(List<FuelSupply> modelList) {
        return modelList.stream().map(item -> this.map(item, FuelSupplyDto.class))
                .collect(Collectors.toList());
    }

    public FuelSupply model(FuelSupplyDto fuelSupplyDto) {
        return this.map(fuelSupplyDto, FuelSupply.class);
    }

    public FuelSupplyDto modelDto(FuelSupply fuelSupply) {
        return this.map(fuelSupply, FuelSupplyDto.class);
    }
}
