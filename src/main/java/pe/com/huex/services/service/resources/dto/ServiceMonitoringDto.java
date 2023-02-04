package pe.com.huex.services.service.resources.dto;

import lombok.Data;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.Date;

@Data
public class ServiceMonitoringDto {

    private Long id;

    private TrackingService trackingService;

    private Date dateHour;

    private String status;

    private String observation;

    private byte[] photoMonitoring;
}
