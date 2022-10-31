package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.model.entity.DocumentUnit;

import java.util.List;

@Repository
public interface IDocumentUnitRepository extends JpaRepository<DocumentUnit, Long> {

    List<DocumentUnit> findAll();

    DocumentUnit findById(int id);

    DocumentUnit save(DocumentUnit documentUnit);
}