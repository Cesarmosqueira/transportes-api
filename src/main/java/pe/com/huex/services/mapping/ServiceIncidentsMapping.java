package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.services.domain.model.entity.ServiceIncidents;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceIncidentsMapping extends ModelMapper implements Serializable {

    public ServiceIncidentsMapping() {

        super();
    }

    public List<ServiceIncidentsDto> modelList(List<ServiceIncidents> modelList) {
        return modelList.stream().map(item -> this.map(item, ServiceIncidentsDto.class))
                .collect(Collectors.toList());
    }

    public ServiceIncidents model(ServiceIncidentsDto serviceIncidentsDto) {

        return this.map(serviceIncidentsDto, ServiceIncidents.class);
    }

    public ServiceIncidentsDto modelDto(ServiceIncidents serviceIncidents) {

        return this.map(serviceIncidents, ServiceIncidentsDto.class);
    }
}
