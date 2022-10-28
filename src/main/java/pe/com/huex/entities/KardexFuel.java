package pe.com.huex.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "kardex_fuel")
public class KardexFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    private TruckFleet truckFleet;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "amount_fuel", nullable = false)
    private Integer amountFuel;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "duty_manager", length = 40)
    private String dutyManager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TruckFleet getTruckFleet() {
        return truckFleet;
    }

    public void setTruckFleet(TruckFleet idTruckFleet) {
        this.truckFleet = truckFleet;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getAmountFuel() {
        return amountFuel;
    }

    public void setAmountFuel(Integer amountFuel) {
        this.amountFuel = amountFuel;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDutyManager() {
        return dutyManager;
    }

    public void setDutyManager(String dutyManager) {
        this.dutyManager = dutyManager;
    }

}