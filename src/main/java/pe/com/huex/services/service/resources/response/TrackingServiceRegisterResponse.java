package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrackingServiceRegisterResponse {

    private TrackingServiceDto trackingServiceDto = null;

    public TrackingServiceRegisterResponse trackingService(TrackingServiceDto trackingServiceDto) {
        this.trackingServiceDto = trackingServiceDto;
        return this;
    }
}
