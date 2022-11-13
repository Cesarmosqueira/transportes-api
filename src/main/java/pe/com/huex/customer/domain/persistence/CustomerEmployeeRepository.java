package pe.com.huex.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.customer.domain.entities.CustomerEmployee;

public interface CustomerEmployeeRepository extends JpaRepository<CustomerEmployee, Long> {

}
