package pe.com.huex.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.huex.security.domain.entities.Menu;

public interface IMenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM menu k WHERE id_parent = ?1 AND id_child = ?2 AND menu_status = 'A'", nativeQuery = true)
    Menu findByIdParentAndIdChild(Long idParent, Long idChild);
}