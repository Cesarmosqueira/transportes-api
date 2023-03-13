package pe.com.huex.services.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "tracking.GetAllTrackingServices",
        procedureName = "gettrackingservices",
        resultClasses = {TrackingServiceLight.class},
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        })
public class TrackingServiceLight {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_service", nullable = false)
    private Date dateService;
    @Column(name = "tract_plate")
    private String tractPlate;
    @Column(name = "social_reason")
    private String socialReason;
    @Column(name = "route_start")
    private String routeStart;
    @Column(name = "route_end")
    private String routeEnd;
    @Column(name = "route_detail")
    private String routeDetail;
    @Column(name = "destination_detail")
    private String destinationDetail;
    @Column(name = "number_points")
    private Long numberPoints;
    @Column(name = "service_Type")
    private String serviceType;
    @Column(name = "additional_cost")
    private String additionalCost;
    @Column(name = "observations")
    private String observations;
    @Column(name = "guide_number")
    private String guideNumber;
    @Column(name = "date_precharge")
    private Date datePrecharge;
    @Column(name = "preload_status")
    private String preloadStatus;
    @Column(name = "scheduled_appointment")
    private Date scheduledAppointment;
    @Column(name = "full_name_driver")
    private String fullNameDriver;
    @Column(name = "full_name_copilot")
    private String fullNameCopilot;
    @Column(name = "full_name_stevedore")
    private String fullNameStevedore;
    @Column(name = "date_time_completion")
    private Date dateTimeCompletion;
    @Column(name = "money_delivered")
    private BigDecimal moneyDelivered;
    @Column(name = "detail_money")
    private String detailMoney;
    @Column(name = "operation")
    private String operation;
    @Column(name = "condition")
    private String condition;
    @Column(name = "invoiced")
    private String invoiced;
    @Column(name = "charge")
    private String charge;
    @Column(name = "documentary_status")
    private String documentaryStatus;
    @Column(name = "ton_number")
    private String tonNumber;
    @Column(name = "volume")
    private int volume;
}