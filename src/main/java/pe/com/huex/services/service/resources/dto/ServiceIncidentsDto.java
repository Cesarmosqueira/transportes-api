package pe.com.huex.services.service.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.Date;

@Data
public class ServiceIncidentsDto {

    private Long id;
    private ServiceIncidentsTrackingDto trackingService;
    private String folio;
    private String sku;
    private String nameProduct;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date observationDate;
    private String damageType;
    private String motive;
    private String responsible;
    private String fullName;
    private String quantityUnits;
    private String observation;
    private String stored;
    private String grt;
    private String grr;
    private String order;
}
