package pe.com.huex.providers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.providers.domain.model.entity.KardexFuel;

import java.util.List;

@Repository
public interface IFuelSupplyRepository extends JpaRepository<FuelSupply,Long>{
    @Query(value = "SELECT * FROM fuel_supply k WHERE status = 'D' ", nativeQuery = true)
    List<FuelSupply> lisFuelSupplyAvailable();
}
