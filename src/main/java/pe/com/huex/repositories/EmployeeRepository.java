package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
