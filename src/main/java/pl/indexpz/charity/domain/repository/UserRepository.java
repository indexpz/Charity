package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
