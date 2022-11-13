package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.customer.domain.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
