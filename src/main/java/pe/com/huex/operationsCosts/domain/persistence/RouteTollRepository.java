package pe.com.huex.operationsCosts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.operationsCosts.domain.entities.RouteToll;

@Repository
public interface RouteTollRepository extends JpaRepository<RouteToll,Long> {

}
