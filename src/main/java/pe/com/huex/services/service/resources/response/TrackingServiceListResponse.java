package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

import java.util.List;

@Data
@NoArgsConstructor
public class TrackingServiceListResponse {
    private List<TrackingServiceDto> trackingsService = null;

    public TrackingServiceListResponse trackingServiceList(List<TrackingServiceDto> trackingServiceDtos) {
        this.trackingsService = trackingServiceDtos;
        return this;
    }
}
