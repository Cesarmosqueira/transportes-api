package pe.com.huex.services.service.resources.dto;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TrackingServiceDto {
    private Long id;
    private Date dateService;
    private Long idTruckFleet;
    private Long volume;
    private Long requestedVolume;
    private String bill;
    private String destinationDetail;
    private String zone;
    private Long numberPoints;
    private String serviceType;
    private String additionalCost;
    private String observations;
    private String guideNumber;
    private Date datePrecharge;
    private String preloadStatus;
    private Date scheduledAppointment;
    private Long idRates;
    private Long idDriver;
    private Long idCopilot;
    private Long idStevedore;
    private Date dateTimeCompletion;
    private Long weightLoad;
    private BigDecimal moneyDelivered;
    private String detailMoney;
    private String operation;
    private String condition;
    private String monitoring;
    private byte[] photoInsurance;
}