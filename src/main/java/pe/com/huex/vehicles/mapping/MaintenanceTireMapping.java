package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.entities.MaintenanceTire;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class MaintenanceTireMapping extends ModelMapper implements Serializable {

    public List<MaintenanceTireDto> modelList(List<MaintenanceTire> modelList) {
        return modelList.stream().map(item -> this.map(item, MaintenanceTireDto.class))
                .collect(Collectors.toList());
    }

    public MaintenanceTire model(MaintenanceTireDto modelDto) {
        return this.map(modelDto, MaintenanceTire.class);
    }

    public MaintenanceTireDto modelDto(MaintenanceTire model) {
        return this.map(model, MaintenanceTireDto.class);
    }
}
