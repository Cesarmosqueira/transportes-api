package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.MaintenanceOil;

public interface MaintenanceOilRepository extends JpaRepository<MaintenanceOil, Long> {
}