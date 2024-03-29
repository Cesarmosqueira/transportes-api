package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.vehicles.domain.entities.FuelControl;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @Column(name = "date_service", nullable = false)
    private Date dateService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_truck_fleet")
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "destination_detail", length = 256)
    private String destinationDetail;

    @Column(name = "number_points")
    private Long numberPoints;

    @Column(name = "service_type", length = 64)
    private String serviceType;

    @Column(name = "additional_cost", length = 256)
    private String additionalCost;

    @Column(name = "observations", length = 256)
    private String observations;

    @Column(name = "guide_number", length = 128)
    private String guideNumber;

    @Column(name = "date_precharge")
    private Date datePrecharge;

    @Column(name = "preload_status", length = 64)
    private String preloadStatus;

    @Column(name = "scheduled_appointment")
    private Date scheduledAppointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rate")
    @JsonIgnore
    private Rate rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver")
    @JsonIgnore
    private Employee driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_copilot")
    @JsonIgnore
    private Employee copilot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stevedore")
    @JsonIgnore
    private Employee stevedore;

    @Column(name = "date_time_completion")
    private Date dateTimeCompletion;

    @Column(name = "money_delivered")
    private BigDecimal moneyDelivered;

    @Column(name = "detail_money", length = 250)
    private String detailMoney;

    @Column(name = "operation", length = 128)
    private String operation;

    @Column(name = "condition", length = 128)
    private String condition;


    @Column(nullable = true, length = 256)
    private byte[] photoInsurance;

    @Column(name = "charge", length = 50)
    private String charge;

    @Column(name = "invoiced", length = 50)
    private String invoiced;

    @Column(name = "documentary_status", length = 128)
    private String documentaryStatus;

    @Column(name = "expense_status",length = 128)
    private String expenseStatus;

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<SettlementSummary> settlementSummaries = new ArrayList<>();

    @OneToMany(mappedBy = "trackingService", cascade = CascadeType.ALL)
    private List<ServiceIncidents> serviceIncidents = new ArrayList<>();

    @OneToMany(mappedBy = "TrackingService", cascade = CascadeType.ALL)
    private List<ServiceMonitoring> serviceMonitoring = new ArrayList<>();

    @OneToMany(mappedBy = "trackingService",cascade = CascadeType.ALL)
    private List<FuelControl> fuelControls=new ArrayList<>();
}