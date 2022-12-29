package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.services.domain.entities.ExpenseType;
import pe.com.huex.services.domain.entities.ServiceMonitoring;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceMonitoringMapping extends ModelMapper implements Serializable {

    public ServiceMonitoringMapping() {
        super();
    }

    public List<ServiceMonitoringDto> modelList(List<ServiceMonitoring> modelList) {
        return modelList.stream().map(item -> this.map(item, ServiceMonitoringDto.class))
                .collect(Collectors.toList());
    }

    public ServiceMonitoring model(ServiceMonitoringDto serviceMonitoringDto) {

        return this.map(serviceMonitoringDto, ServiceMonitoring.class);
    }

    public ServiceMonitoringDto modelDto(ServiceMonitoring serviceMonitoring) {

        return this.map(serviceMonitoring, ServiceMonitoringDto.class);
    }
}
