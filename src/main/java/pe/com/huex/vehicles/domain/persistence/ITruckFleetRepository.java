package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.model.entity.TruckFleet;

import java.util.List;

@Repository
public interface ITruckFleetRepository extends JpaRepository<TruckFleet, Long> {

    List<TruckFleet> findAll();

    TruckFleet findById(int id);

    TruckFleet save(TruckFleet truckFleet);
}