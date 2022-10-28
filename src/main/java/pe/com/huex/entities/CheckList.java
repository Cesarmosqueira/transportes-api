package pe.com.huex.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "check_list")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    private TruckFleet truckFleet;

    @Column(name = "date")
    private Date date;

    @Column(name = "name_photo")
    private String namePhoto;

    @Column(name = "photo")
    private byte[] photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TruckFleet getTruckFleet() {
        return truckFleet;
    }

    public void setTruckFleet(TruckFleet truckFleet) {
        this.truckFleet = truckFleet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}