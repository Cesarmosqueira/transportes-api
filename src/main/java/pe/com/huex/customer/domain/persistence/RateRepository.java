package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query(value = "SELECT * FROM rate r order by r.route_id desc", nativeQuery = true)
    List<Rate> listRateAsc();

}
