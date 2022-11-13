package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.huex.customer.domain.entities.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
