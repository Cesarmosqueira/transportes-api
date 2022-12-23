package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.MaintenanceTire;

import java.util.List;

@Repository
public interface IMaintenanceTireRepository extends JpaRepository<MaintenanceTire, Long> {

    List<MaintenanceTire> findAll();

    MaintenanceTire findById(int id);

    MaintenanceTire save(MaintenanceTire maintenanceTire);

    List<MaintenanceTire> findByIdTruckFleet(Long id);
}