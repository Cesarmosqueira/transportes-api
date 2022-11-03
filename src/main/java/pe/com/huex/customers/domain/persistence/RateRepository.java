package pe.com.huex.customers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.customers.domain.entity.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {
}
