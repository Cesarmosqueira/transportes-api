package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.MaintenanceTire;

import java.util.List;

@Repository
public interface IMaintenanceTireRepository extends JpaRepository<MaintenanceTire, Long> {

    List<MaintenanceTire> findAll();

    MaintenanceTire findById(int id);

    MaintenanceTire save(MaintenanceTire maintenanceTire);

    @Query(value = "SELECT * FROM maintenance_tire k WHERE id_truck_fleet = ? 1 ", nativeQuery = true)
    List<MaintenanceTire> findByIdTruckFleet(Long id);
}