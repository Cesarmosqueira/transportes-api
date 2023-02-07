package pe.com.huex.services.service.resources.dto;

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
    private Date dateService;
    private TruckFleetDto truckFleet;
    private Long requestedVolume;
    private String destinationDetail;
    private Long numberPoints;
    private String serviceType;
    private String additionalCost;
    private String observations;
    private String guideNumber;
    private Date datePrecharge;
    private String preloadStatus;
    private Date scheduledAppointment;
    private RateDto rate;
    private EmployeeDto driver;
    private EmployeeDto copilot;
    private EmployeeDto stevedore;
    private Date dateTimeCompletion;
    private Long weightLoad;
    private BigDecimal moneyDelivered;
    private String detailMoney;
    private String operation;
    private String condition;
    private byte[] photoInsurance;
    private String invoiced;
    private String charge;
    private List<SettlementSummaryDto> settlementSummary;
    private List<ServiceMonitoringDto> serviceMonitoring;
    private List<ServiceIncidentsDto> serviceIncidents;
}