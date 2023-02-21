package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.List;

@Repository
public interface CustomerEmployeeRepository extends JpaRepository<CustomerEmployee, Long> {

    @Query(value = "SELECT * FROM customer_employee ce order by ce.id desc", nativeQuery = true)
    List<CustomerEmployee> listCustomerEmployeeDesc();

}
