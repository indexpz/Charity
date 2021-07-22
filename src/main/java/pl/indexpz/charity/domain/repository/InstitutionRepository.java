package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findInstitutionByName(String name);
}