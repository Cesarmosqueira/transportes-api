package pe.com.huex.services.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tracking_services")
public class TrackingService {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_service", nullable = false)
    private Date dateService;

    @Column(name = "id_truck_fleet", nullable = false)
    private Long idTruckFleet;


    @Column(name = "requested_volume")
    private Long requestedVolume;

    @Column(name = "bill", nullable = false, length = 30)
    private String bill;

    @Column(name = "destination_detail", nullable = false, length = 30)
    private String destinationDetail;


    @Column(name = "number_points")
    private Long numberPoints;

    @Column(name = "service_type", length = 30)
    private String serviceType;

    @Column(name = "additional_cost", length = 20)
    private String additionalCost;

    @Column(name = "observations", length = 30)
    private String observations;

    @Column(name = "guide_number", length = 20)
    private String guideNumber;

    @Column(name = "date_precharge")
    private Date datePrecharge;

    @Column(name = "preload_status", length = 20)
    private String preloadStatus;

    @Column(name = "scheduled_appointment")
    private Date scheduledAppointment;

    @Column(name = "id_rates", nullable = false)
    private Long idRates;

    @Column(name = "id_driver", nullable = false)
    private Long idDriver;

    @Column(name = "id_copilot")
    private Long idCopilot;

    @Column(name = "id_stevedore")
    private Long idStevedore;

    @Column(name = "date_time_completion")
    private Date dateTimeCompletion;

    @Column(name = "weight_load")
    private Long weightLoad;

    @Column(name = "money_delivered")
    private BigDecimal moneyDelivered;

    @Column(name = "detail_money", length = 250)
    private String detailMoney;

    @Column(name = "operation", length = 50)
    private String operation;

    @Column(name = "condition", length = 50)
    private String condition;

    @Column(name = "monitoring", length = 50)
    private String monitoring;

    @Column(name = "photo_insurance")
    private Long photoInsurance;

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<SettlementSummary> settlementSummaries = new ArrayList<>();

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<ServiceIncidents> serviceIncidents = new ArrayList<>();

    @OneToMany(mappedBy = "TrackingService", cascade = CascadeType.ALL)
    private List<ServiceMonitoring> serviceMonitoring = new ArrayList<>();
}