package pe.com.huex.services.service.resources.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrackingServiceRouteDto {

    private Long id;
    private String routeStart;
    private String routeEnd;
}
