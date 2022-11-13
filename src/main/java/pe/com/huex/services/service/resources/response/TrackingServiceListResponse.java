package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrackingServiceListResponse {
    private List<TrackingServiceDto> trackingServiceDtos = null;

    public TrackingServiceListResponse trackingServiceList(List<TrackingServiceDto> trackingServiceDtos) {
        this.trackingServiceDtos = trackingServiceDtos;
        return this;
    }
}
