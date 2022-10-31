package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.model.entity.MaintenanceOil;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class MaintenanceOilMapping extends ModelMapper implements Serializable {

    public List<MaintenanceOilDto> modelList(List<MaintenanceOil> modelList) {
        return modelList.stream().map(item -> this.map(item, MaintenanceOilDto.class))
                .collect(Collectors.toList());
    }

    public MaintenanceOil model(MaintenanceOilDto modelDto) {
        return this.map(modelDto, MaintenanceOil.class);
    }

    public MaintenanceOilDto modelDto(MaintenanceOil model) {
        return this.map(model, MaintenanceOilDto.class);
    }
}
