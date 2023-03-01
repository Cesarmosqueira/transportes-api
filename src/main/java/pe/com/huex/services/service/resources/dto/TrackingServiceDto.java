package pe.com.huex.services.service.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TrackingServiceDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date dateService;
    private TrackingServiceTruckFleetDto truckFleet;
    private String destinationDetail;
    private Long numberPoints;
    private String serviceType;
    private String additionalCost;
    private String observations;
    private String guideNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date datePrecharge;
    private String preloadStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date scheduledAppointment;
    private TrackingServiceRateDto rate;
    private TrackingServiceEmployeeDto driver;
    private TrackingServiceEmployeeDto copilot;
    private TrackingServiceEmployeeDto stevedore;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateTimeCompletion;
    private BigDecimal moneyDelivered;
    private String detailMoney;
    private String operation;
    private String condition;
    private byte[] photoInsurance;
    private String invoiced;
    private String charge;
    private String documentaryStatus;
    private List<SettlementSummaryDto> settlementSummary;
    private List<ServiceMonitoringDto> serviceMonitoring;
    private List<ServiceIncidentsDto> serviceIncidents;
}