package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.FuelControl;

@Repository
public interface IFuelControlRepository extends JpaRepository<FuelControl, Long> {

}
