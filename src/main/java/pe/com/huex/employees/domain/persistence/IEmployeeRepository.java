package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee e order by e.full_name ", nativeQuery = true)
    List<Employee> listEmployeeDesc();
}
