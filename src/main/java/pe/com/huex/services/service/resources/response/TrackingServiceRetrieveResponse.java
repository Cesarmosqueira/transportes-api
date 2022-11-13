package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrackingServiceRetrieveResponse {
    private TrackingServiceDto trackingServiceDto = null;

    public TrackingServiceRetrieveResponse trackingService(TrackingServiceDto trackingServiceDto) {
        this.trackingServiceDto = trackingServiceDto;
        return this;
    }
}
