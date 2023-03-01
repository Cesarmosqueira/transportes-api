package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.com.huex.providers.domain.model.entity.KardexFuel;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.services.domain.entities.TrackingService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "truck_fleet")
public class TruckFleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Provider", nullable = false)
    @JsonIgnore
    private Provider provider;

    @Column(name = "tract_plate", nullable = false, length = 6)
    private String tractPlate;

    @Column(name = "van_plate", length = 6)
    private String vanPlate;

    @Column(name = "brand", length = 64)
    private String brand;

    @Column(name = "volume",nullable = false)
    private Double volume;
    
    @Column(name = "fabrication_date")
    private Date fabricationDate;

    @Column(name = "ton_number")
    private Double tonNumber;

    @Column(name = "axes")
    private Integer axes;

    @Column(name = "model", length = 64)
    private String model;

    @Column(name = "high_wide_long", length = 64)
    private String highWideLong;

    @Column(name = "fleet_type", length = 64,nullable = false)
    private String fleetType;

    @OneToMany(mappedBy = "truckFleet", cascade = CascadeType.ALL)
    private List<KardexFuel> kardexFuels = new ArrayList<>();

    @OneToMany(mappedBy = "truckFleet", cascade = CascadeType.ALL)
    private List<CheckList> checkLists = new ArrayList<>();

    @OneToMany(mappedBy = "truckFleet", cascade = CascadeType.ALL)
    private List<MaintenanceOil> maintenanceOils = new ArrayList<>();

    @OneToMany(mappedBy = "truckFleet", cascade = CascadeType.ALL)
    private List<MaintenanceTire> maintenanceTires = new ArrayList<>();

    @OneToMany(mappedBy = "truckFleet", cascade = CascadeType.ALL)
    private List<DocumentUnit> documentUnits = new ArrayList<>();

    @OneToMany(mappedBy = "truckFleet", cascade = {CascadeType.PERSIST,CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<TrackingService> trackingServices = new ArrayList<>();
}