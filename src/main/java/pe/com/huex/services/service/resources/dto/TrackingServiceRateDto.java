package pe.com.huex.services.service.resources.dto;

import lombok.*;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrackingServiceRateDto {
    private Long id;
    private TrackingServiceCustomerDto customer;
    private TrackingServiceRouteDto route;
    private String tonNumber;
    private int volume;
    private String routeDetail;
}
