package pl.indexpz.charity.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Institution;

@Service
@Repository
@Transactional
public interface InterfaceInstitutionService {

    Institution addInstitution(Institution institutionToAdd);

    Institution getInstitutionById(Long institutionId);

    Institution getInstitutionByName(String institutionName);

    public void updateInstitution(Institution institutionToUpdate);

    public void deleteInstitution(Institution institutionToDelete);
}
