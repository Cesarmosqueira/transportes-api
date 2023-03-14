package pe.com.huex.operationsCosts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.operationsCosts.domain.entities.Toll;

@Repository
public interface TollRepository extends JpaRepository<Toll,Long> {
}
