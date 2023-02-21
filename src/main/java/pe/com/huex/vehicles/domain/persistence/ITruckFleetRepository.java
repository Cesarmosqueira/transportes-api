package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.TrackingService;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.List;

@Repository
public interface ITruckFleetRepository extends JpaRepository<TruckFleet, Long> {

    @Query(value = "SELECT * FROM truck_fleet tf  order by tf.id_provider asc", nativeQuery = true)
    List<TruckFleet> listTruckFleetAsc();

    List<TruckFleet> findAll();

    TruckFleet findById(int id);

    TruckFleet save(TruckFleet truckFleet);

    void deleteById(Long id);

}