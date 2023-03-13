package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.entities.FuelControl;
import pe.com.huex.vehicles.domain.entities.TruckFleet;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class FuelControlMapping extends ModelMapper implements Serializable {

    public List<FuelControlDto> modelList(List<FuelControl> modelList) {
        return modelList.stream().map(item -> this.map(item, FuelControlDto.class))
                .collect(Collectors.toList());
    }

    public FuelControl model(FuelControlDto modelDto) {

        return this.map(modelDto, FuelControl.class);
    }

    public FuelControlDto modelDto(FuelControl model) {
        return this.map(model, FuelControlDto.class);
    }
}
