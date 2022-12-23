package pe.com.huex.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.security.domain.entities.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String name);
}