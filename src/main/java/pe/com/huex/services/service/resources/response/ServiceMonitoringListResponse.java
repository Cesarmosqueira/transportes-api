package pe.com.huex.services.service.resources.response;


import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ServiceMonitoringListResponse {

    private List<ServiceMonitoringDto> serviceMonitoring = null;

    public ServiceMonitoringListResponse serviceMonitoringList(List<ServiceMonitoringDto> serviceMonitoringDtoList) {
        this.serviceMonitoring = serviceMonitoringDtoList;
        return this;
    }
}
