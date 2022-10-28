package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.KardexFuel;

public interface KardexFuelRepository extends JpaRepository<KardexFuel, Long> {
}