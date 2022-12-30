package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pe.com.huex.customer.domain.entities.CustomerEmployee;

@Repository
public interface CustomerEmployeeRepository extends JpaRepository<CustomerEmployee, Long> {

}
