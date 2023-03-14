package pe.com.huex.operationsCosts.services.resources.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TollDto {

    private Long id;
    private String place;
    private String configuration;
    private Double cost;
}
