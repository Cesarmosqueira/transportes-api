package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.entities.ExpenseType;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long> {
}
