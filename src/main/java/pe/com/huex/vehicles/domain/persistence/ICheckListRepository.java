package pe.com.huex.vehicles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.vehicles.domain.model.entity.CheckList;
import pe.com.huex.vehicles.domain.model.entity.DocumentUnit;

import java.util.List;

@Repository
public interface ICheckListRepository extends JpaRepository<CheckList, Long> {

    List<CheckList>  findAll();

    CheckList findById(int id);

    CheckList save(CheckList checkList);

    List<CheckList> findByIdTruckFleet(Long id);
}