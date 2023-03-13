package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.Date;
import java.util.List;

@Repository
public interface ITrackingServiceRepository extends JpaRepository<TrackingService, Long> {

    List<TrackingService>  findAll();


    @Query(value = "SELECT * FROM tracking_services ts where ts.date_service between ?1 and ?2", nativeQuery = true)
    List<TrackingService> listTrackingServiceFindByRangeDate(Date dateStart, Date dateEnd);

    TrackingService findById(int id);

    TrackingService save(TrackingService trackingService);
}