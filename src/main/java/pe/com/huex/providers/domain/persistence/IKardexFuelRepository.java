package pe.com.huex.providers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.huex.providers.domain.model.entity.KardexFuel;

import java.util.List;

public interface IKardexFuelRepository extends JpaRepository<KardexFuel, Long> {
    List<KardexFuel> findAll();

    KardexFuel findById(int id);

    KardexFuel save(KardexFuel kardexFuel);

    @Query(value = "SELECT * FROM kardex_fuel k WHERE id_truck_fleet = ? 1 ", nativeQuery = true)
    List<KardexFuel> findByIdTruckFleet(Long id);
}