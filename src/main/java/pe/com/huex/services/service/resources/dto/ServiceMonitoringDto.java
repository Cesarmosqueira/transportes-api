package pe.com.huex.services.service.resources.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ServiceMonitoringDto {

    private Long id;

    private Long idTrackingService;

    private Date dateHour;

    private String status;

    private String observation;

    private String photoMonitoring;
}
