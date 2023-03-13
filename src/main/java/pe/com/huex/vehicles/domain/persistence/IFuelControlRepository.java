package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.FuelControl;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.List;

@Repository
public interface IFuelControlRepository extends JpaRepository<FuelControl, Long> {

    @Query(value = "SELECT* FROM fuel_control fc ORDER BY fc.id desc", nativeQuery = true)
    List<FuelControl> listFuelControlDesc();



}
