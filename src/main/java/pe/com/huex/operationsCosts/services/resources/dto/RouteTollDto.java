package pe.com.huex.operationsCosts.services.resources.dto;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.RouteDto;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RouteTollDto {

    private Long id;

    private RouteDto route;

    private TollDto toll;

    private String place;
}
