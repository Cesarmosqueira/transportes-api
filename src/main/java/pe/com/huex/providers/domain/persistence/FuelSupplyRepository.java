package pe.com.huex.providers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.providers.domain.model.entity.FuelSupply;

@Repository
public interface FuelSupplyRepository extends JpaRepository<FuelSupply,Long>{
}
