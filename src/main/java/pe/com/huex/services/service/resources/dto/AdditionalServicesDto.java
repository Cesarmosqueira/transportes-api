package pe.com.huex.services.service.resources.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdditionalServicesDto {

    private Long id;

    private Date dateService;

    private TrackingServiceCustomerDto customer;

    private TrackingServiceTruckFleetDto truckFleet;

    private String resources;

    private Double cost;

    private String invoiceDetail;

    private String status;

    private String observation;

    private String personRequest;
}
