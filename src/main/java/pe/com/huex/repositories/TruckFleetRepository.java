package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.TruckFleet;

public interface TruckFleetRepository extends JpaRepository<TruckFleet, Long> {
}