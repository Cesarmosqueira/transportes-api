package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.CheckList;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
}