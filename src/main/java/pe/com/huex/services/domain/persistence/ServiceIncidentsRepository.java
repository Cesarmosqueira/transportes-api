package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.ServiceIncidents;

import java.util.List;

@Repository
public interface ServiceIncidentsRepository extends JpaRepository<ServiceIncidents,Long> {
    @Query(value = "SELECT * FROM service_incident WHERE tracking_service_id = ?1", nativeQuery = true)
    List<ServiceIncidents> findByIdTracking(Long id);

    @Query(value = "SELECT* FROM service_incident si order by si.id desc", nativeQuery = true)
    List<ServiceIncidents> listIncidentService();


}
