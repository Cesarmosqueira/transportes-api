package pe.com.huex.servicetracking.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.servicetracking.domain.entity.ExpenseType;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long> {
}
