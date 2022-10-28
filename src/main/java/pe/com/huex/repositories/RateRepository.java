package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {
}
