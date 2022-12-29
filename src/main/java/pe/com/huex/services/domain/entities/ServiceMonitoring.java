package pe.com.huex.services.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "service_monitoring")
public class ServiceMonitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_tracking_service")
    private Long idTrackingService;

    @Column(name = "date_hour")
    private Date dateHour;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "Observation", length = 200)
    private String observation;

    @Column(name = "photo_monitoring")
    private String photoMonitoring;


}
