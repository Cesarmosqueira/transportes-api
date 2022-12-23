package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.MaintenanceOil;

import java.util.List;

@Repository
public interface IMaintenanceOilRepository extends JpaRepository<MaintenanceOil, Long> {

    List<MaintenanceOil> findAll();

    MaintenanceOil findById(int id);

    MaintenanceOil save(MaintenanceOil maintenanceOil);

    List<MaintenanceOil> findByIdTruckFleet(Long id);
}