package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
