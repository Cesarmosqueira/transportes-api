package pe.com.huex.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "truck_fleet")
public class TruckFleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_provider", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Provider provider;

    @Column(name = "tract_plate", nullable = false, length = 6)
    private String tractPlate;

    @Column(name = "van_plate", length = 6)
    private String vanPlate;

    @Column(name = "brand", length = 10)
    private String brand;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "fabrication_date")
    private Date fabricationDate;

    @Column(name = "ton_number")
    private Double tonNumber;

    @Column(name = "axes")
    private Integer axes;

    @Column(name = "model", length = 30)
    private String model;

    @Column(name = "high_wide_long", length = 30)
    private String highWideLong;

    @Column(name = "fleet_type", length = 30)
    private String fleetType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getTractPlate() {
        return tractPlate;
    }

    public void setTractPlate(String tractPlate) {
        this.tractPlate = tractPlate;
    }

    public String getVanPlate() {
        return vanPlate;
    }

    public void setVanPlate(String vanPlate) {
        this.vanPlate = vanPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Double getTonNumber() {
        return tonNumber;
    }

    public void setTonNumber(Double tonNumber) {
        this.tonNumber = tonNumber;
    }

    public Integer getAxes() {
        return axes;
    }

    public void setAxes(Integer axes) {
        this.axes = axes;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHighWideLong() {
        return highWideLong;
    }

    public void setHighWideLong(String highWideLong) {
        this.highWideLong = highWideLong;
    }

    public String getFleetType() {
        return fleetType;
    }

    public void setFleetType(String fleetType) {
        this.fleetType = fleetType;
    }

}