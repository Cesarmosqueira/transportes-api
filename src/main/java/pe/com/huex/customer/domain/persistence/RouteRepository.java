package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.huex.customer.domain.entities.Route;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {


    @Query(value = "SELECT * FROM route r order by r.route_end", nativeQuery = true)
    List<Route> listRouteAsc();
}
