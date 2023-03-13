package pe.com.huex.vehicles.service.resources.dto;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;


@Getter
@Setter
public class FuelControlDto {


    private Long id;

    private FuelControlTrackingDto trackingService;

    private String firstPlace;
    private Double firstQuantity;

    private String secondPlace;
    private Double secondQuantity;

    private String thirdPlace;
    private Double thirdQuantity;

    private String fourthPlace;
    private Double forthQuantity;

    private String fifthPlace;
    private Double fifthQuantity;

    private String sixthPlace;
    private String sixthQuantity;

    private Double totalGallons;

    private Double target;

    private Double difference;

    private String observation;
}
