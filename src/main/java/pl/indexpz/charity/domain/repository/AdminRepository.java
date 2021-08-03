package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
