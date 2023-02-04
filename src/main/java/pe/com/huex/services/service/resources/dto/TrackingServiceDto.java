package pe.com.huex.services.service.resources.dto;

import lombok.*;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TrackingServiceDto {
    private Long id;
    private Date dateService;
    private TruckFleet truckFleet;
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
    private Rate rate;
    private Employee driver;
    private Employee copilot;
    private Employee stevedore;
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