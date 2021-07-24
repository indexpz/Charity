package pl.indexpz.charity.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Institution;

import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public interface InstitutionServiceInterface {

    Institution addInstitution(Institution institutionToAdd);

    List<Institution> getAllInstitutions();

    Optional<Institution> getInstitutionById(Long institutionId);

    Institution getInstitutionByName(String institutionName);

    public void updateInstitution(Institution institutionToUpdate);

    public void deleteInstitution(Institution institutionToDelete);
}
