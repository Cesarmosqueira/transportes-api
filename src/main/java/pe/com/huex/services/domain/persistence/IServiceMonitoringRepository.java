package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.ServiceMonitoring;

import java.util.List;

@Repository
public interface IServiceMonitoringRepository extends JpaRepository<ServiceMonitoring,Long> {
    @Query(value = "SELECT * FROM service_monitoring WHERE tracking_service_id = ?1", nativeQuery = true)
    List<ServiceMonitoring> findByIdTracking(Long id);
}
