package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.model.entity.SettlementSummary;

@Repository
public interface SettlementSummaryRepository extends JpaRepository<SettlementSummary,Long> {

}
