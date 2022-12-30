package pe.com.huex.services.service.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;

@Data
@NoArgsConstructor
public class ServiceMonitoringResponse {

    private ServiceMonitoringDto serviceMonitoringDto = null;

    public ServiceMonitoringResponse serviceMonitoring(ServiceMonitoringDto serviceMonitoringDto) {
        this.serviceMonitoringDto = serviceMonitoringDto;
        return this;
    }
}
