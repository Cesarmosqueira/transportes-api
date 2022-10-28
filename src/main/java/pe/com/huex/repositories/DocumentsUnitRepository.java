package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.DocumentUnit;

public interface DocumentsUnitRepository extends JpaRepository<DocumentUnit, Long> {
}