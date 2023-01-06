package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.entities.CheckList;

import java.util.List;

@Repository
public interface ICheckListRepository extends JpaRepository<CheckList, Long> {

    List<CheckList>  findAll();

    CheckList findById(int id);

    CheckList save(CheckList checkList);

    @Query(value = "SELECT * FROM checkList k WHERE id_truck_fleet = ? 1 ", nativeQuery = true)
    List<CheckList> findByIdTruckFleet(Long id);
}