package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

@Data
@NoArgsConstructor
public class TrackingServiceResponse {

    private TrackingServiceDto trackingService = null;

    public TrackingServiceResponse trackingService(TrackingServiceDto trackingServiceDto) {
        this.trackingService = trackingServiceDto;
        return this;
    }
}