package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CheckListDto {
    private Long id;
    private Long idTruckFleet;
    private Date date;
    private String namePhoto;
    private byte[] photo;
}