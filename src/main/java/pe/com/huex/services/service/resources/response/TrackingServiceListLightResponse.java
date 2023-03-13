package pe.com.huex.services.service.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.TrackingServiceLightDto;

import java.util.List;

@Data
@NoArgsConstructor
public class TrackingServiceListLightResponse {
    private List<TrackingServiceLightDto> trackingsService = null;

    public TrackingServiceListLightResponse trackingServiceList(List<TrackingServiceLightDto> trackingServiceDtos) {
        this.trackingsService = trackingServiceDtos;
        return this;
    }
}
