package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.entities.TruckFleet;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TruckFleetMapping  extends ModelMapper implements Serializable {

    public List<TruckFleetDto> modelList(List<TruckFleet> modelList) {
        return modelList.stream().map(item -> this.map(item, TruckFleetDto.class))
                .collect(Collectors.toList());
    }

    public TruckFleet model(TruckFleetDto modelDto) {
        return this.map(modelDto, TruckFleet.class);
    }

    public TruckFleetDto modelDto(TruckFleet model) {
        return this.map(model, TruckFleetDto.class);
    }
}
