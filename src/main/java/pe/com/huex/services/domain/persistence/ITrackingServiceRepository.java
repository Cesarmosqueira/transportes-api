package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.List;

@Repository
public interface ITrackingServiceRepository extends JpaRepository<TrackingService, Long> {

    List<TrackingService>  findAll();

    TrackingService findById(int id);

    TrackingService save(TrackingService trackingService);
}