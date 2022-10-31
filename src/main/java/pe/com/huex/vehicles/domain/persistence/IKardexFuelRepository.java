package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.model.entity.KardexFuel;

import java.util.List;

@Repository
public interface IKardexFuelRepository extends JpaRepository<KardexFuel, Long> {

    List<KardexFuel> findAll();

    KardexFuel findById(int id);

    KardexFuel save(KardexFuel kardexFuel);
}