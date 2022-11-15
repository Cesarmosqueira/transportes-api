package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.model.entity.ServiceIncidents;

@Repository
public interface ServiceIncidentsRepository extends JpaRepository<ServiceIncidents,Long> {
}
