package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.SettlementSummary;

import java.util.List;

@Repository
public interface SettlementSummaryRepository extends JpaRepository<SettlementSummary,Long> {

    @Query(value = "SELECT * FROM settlement_summary WHERE tracking_service_id = ?1", nativeQuery = true)
    List<SettlementSummary> findByIdTracking(Long id);
}
