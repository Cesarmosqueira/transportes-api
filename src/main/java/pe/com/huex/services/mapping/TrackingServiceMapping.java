package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.services.domain.entities.TrackingService;
import pe.com.huex.services.domain.entities.TrackingServiceLight;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceLightDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TrackingServiceMapping extends ModelMapper implements Serializable {

    public List<TrackingServiceLightDto> modelListEspecial(List<TrackingServiceLight> modelList) {
        return modelList.stream().map(item -> this.map(item, TrackingServiceLightDto.class))
                .collect(Collectors.toList());
    }

    public List<TrackingServiceDto> modelList(List<TrackingService> modelList) {
        return modelList.stream().map(item -> this.map(item, TrackingServiceDto.class))
                .collect(Collectors.toList());
    }

    public TrackingService model(TrackingServiceDto modelDto) {
        return this.map(modelDto, TrackingService.class);
    }

    public TrackingServiceDto modelDto(TrackingService model) {
        return this.map(model, TrackingServiceDto.class);
    }
}
