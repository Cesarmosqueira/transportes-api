package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tracking_services")
public class TrackingService {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_service", nullable = false)
    private Date dateService;

    @ManyToOne
    @JoinColumn(name = "id_truck_fleet",nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "requested_volume")
    private Long requestedVolume;

    @Column(name = "destination_detail", length = 30)
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

    @ManyToOne
    @JoinColumn(name = "id_rate",nullable = false)
    @JsonIgnore
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "id_driver",nullable = false)
    @JsonIgnore
    private Employee driver;

    @ManyToOne
    @JoinColumn(name = "id_copilot")
    @JsonIgnore
    private Employee copilot;

    @ManyToOne
    @JoinColumn(name = "id_stevedore")
    @JsonIgnore
    private Employee stevedore;

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


    @Column(nullable = true, length = 256)
    private byte[] photoInsurance;

    @Column(name = "charge", length = 50)
    private String charge;

    @Column(name = "invoiced", length = 50)
    private String invoiced;

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<SettlementSummary> settlementSummaries = new ArrayList<>();

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<ServiceIncidents> serviceIncidents = new ArrayList<>();

    @OneToMany(mappedBy = "TrackingService", cascade = CascadeType.ALL)
    private List<ServiceMonitoring> serviceMonitoring = new ArrayList<>();
}