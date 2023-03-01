package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.sound.midi.Track;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "service_monitoring")
public class ServiceMonitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_service_id", nullable = false)
    @JsonIgnore
    private TrackingService TrackingService;


    @Column(name = "date_hour")
    private Date dateHour;

    @Column(name = "status", length = 128)
    private String status;

    @Column(name = "Observation", length = 200)
    private String observation;

    @Column(name = "photo_monitoring")
    private byte[] photoMonitoring;


}
