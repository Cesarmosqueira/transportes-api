package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.ServiceMonitoring;

@Repository
public interface IServiceMonitoringRepository extends JpaRepository<ServiceMonitoring,Long> {
}
