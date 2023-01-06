package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.DocumentUnit;

import java.util.List;

@Repository
public interface IDocumentUnitRepository extends JpaRepository<DocumentUnit, Long> {

    List<DocumentUnit> findAll();

    DocumentUnit findById(int id);

    DocumentUnit save(DocumentUnit documentUnit);

    @Query(value = "SELECT * FROM document_unit k WHERE id_truck_fleet = ? 1 ", nativeQuery = true)
    List<DocumentUnit> findByIdTruckFleet(Long id);
}