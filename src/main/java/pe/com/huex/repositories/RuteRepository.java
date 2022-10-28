package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.entities.Rute;

@Repository
public interface RuteRepository extends JpaRepository<Rute,Long> {
}
