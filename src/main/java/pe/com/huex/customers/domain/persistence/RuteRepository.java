package pe.com.huex.customers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.customers.domain.model.entity.Rute;

@Repository
public interface RuteRepository extends JpaRepository<Rute,Long> {
}
