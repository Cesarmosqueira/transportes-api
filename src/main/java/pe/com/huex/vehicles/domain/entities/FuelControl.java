package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.services.domain.entities.TrackingService;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "fuel_control")
public class FuelControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_service_id")
    @JsonIgnore
    private TrackingService trackingService;

    @Column(name = "first_place",length = 128)
    private String firstPlace;
    @Column(name = "first_qunatity")
    private Double firstQuantity;

    @Column(name = "second_placa",length = 128)
    private String secondPlace;
    @Column(name = "second_qunatity")
    private Double secondQuantity;

    @Column(name = "third_place",length = 128)
    private String thirdPlace;
    @Column(name = "third_placa")
    private Double thirdQuantity;

    @Column(name = "fourth_place",length = 128)
    private String fourthPlace;
    @Column(name = "forth_quantity")
    private Double forthQuantity;

    @Column(name = "fifth_placa",length = 128)
    private String fifthPlace;
    @Column(name = "fifth_quantity")
    private Double fifthQuantity;

    @Column(name = "sixth_placa",length = 128)
    private String sixthPlace;
    @Column(name = "sixth_quantity")
    private String sixthQuantity;

    @Column(name = "total_gallons")
    private Double totalGallons;

    @Column(name = "target")
    private Double target;

    @Column(name = "difference")
    private Double difference;

}
