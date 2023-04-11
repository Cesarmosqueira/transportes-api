package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.MaintenanceOil;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.List;

@Repository
public interface IMaintenanceOilRepository extends JpaRepository<MaintenanceOil, Long> {

    List<MaintenanceOil> findAll();

    @Query(value = "SELECT * FROM maintenance_oil mo  order by mo.date_change desc", nativeQuery = true)
    List<MaintenanceOil> listMaintenanceOilDesc();

    MaintenanceOil findById(int id);

    MaintenanceOil save(MaintenanceOil maintenanceOil);

    @Query(value = "SELECT * FROM maintenance_oil k WHERE id_truck_fleet = ? 1 ", nativeQuery = true)
    List<MaintenanceOil> findByIdTruckFleet(Long id);
}