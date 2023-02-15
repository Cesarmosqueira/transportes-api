package pe.com.huex.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.com.huex.security.domain.entities.UserMenu;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserMenuRepository extends JpaRepository<UserMenu, Long> {

    @Query(value = "SELECT * FROM user_menu k WHERE id_user = ?1", nativeQuery = true)
    List<UserMenu> findByIdUser(Long idUser);

    @Query(value = "DELETE FROM user_menu k WHERE id_user = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    int deleteByIdUser(Long idUser);
}