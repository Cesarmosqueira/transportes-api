package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.employees.domain.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}