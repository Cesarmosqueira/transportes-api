package pe.com.huex.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "maintenance_oil")
public class MaintenanceOil {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    private TruckFleet truckFleet;

    @Column(name = "change_type")
    private Double changeType;

    @Column(name = "place", length = 30)
    private String place;

    @Column(name = "date_change")
    private Instant dateChange;

    @Column(name = "km_last")
    private Integer kmLast;

    @Column(name = "km_current")
    private Integer kmCurrent;

    @Column(name = "km_next")
    private Integer kmNext;

    @Column(name = "status")
    private Integer status;

    @Column(name = "date_current")
    private Instant dateCurrent;

    @Column(name = "differences")
    private Integer differences;

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

    public Double getChangeType() {
        return changeType;
    }

    public void setChangeType(Double changeType) {
        this.changeType = changeType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Instant getDateChange() {
        return dateChange;
    }

    public void setDateChange(Instant dateChange) {
        this.dateChange = dateChange;
    }

    public Integer getKmLast() {
        return kmLast;
    }

    public void setKmLast(Integer kmLast) {
        this.kmLast = kmLast;
    }

    public Integer getKmCurrent() {
        return kmCurrent;
    }

    public void setKmCurrent(Integer kmCurrent) {
        this.kmCurrent = kmCurrent;
    }

    public Integer getKmNext() {
        return kmNext;
    }

    public void setKmNext(Integer kmNext) {
        this.kmNext = kmNext;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getDateCurrent() {
        return dateCurrent;
    }

    public void setDateCurrent(Instant dateCurrent) {
        this.dateCurrent = dateCurrent;
    }

    public Integer getDifferences() {
        return differences;
    }

    public void setDifferences(Integer differences) {
        this.differences = differences;
    }

}