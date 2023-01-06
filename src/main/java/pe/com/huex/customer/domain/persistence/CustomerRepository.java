package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.customer.domain.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
