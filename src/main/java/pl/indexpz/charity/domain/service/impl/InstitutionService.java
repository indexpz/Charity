package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.repository.InstitutionRepository;
import pl.indexpz.charity.domain.service.InstitutionServiceInterface;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionService implements InstitutionServiceInterface {

    private final InstitutionRepository institutionRepository;

    @Override
    @Transactional
    public Institution addInstitution(Institution institutionToAdd) {
        return institutionRepository.save(institutionToAdd);
    }

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution getInstitutionById(Long institutionId) {
        return institutionRepository.findById(institutionId).orElseThrow((() -> new ResourceNotFoundException("Institution with id " + institutionId + " not exist.")));
    }

    @Override
    public Institution getInstitutionByName(String institutionName) {
        Institution institution = (Institution) institutionRepository.findInstitutionByName(institutionName);
        return institution;
    }

    @Override
    public void updateInstitution(Institution institutionToUpdate) {
        Institution institution = getInstitutionById((institutionToUpdate.getId()));
        institution.setName(institutionToUpdate.getName());
        institution.setDescription(institutionToUpdate.getDescription());
        institutionRepository.save(institution);
    }

    @Override
    public void deleteInstitution(Institution institutionToDelete) {
        Institution institution = getInstitutionById(institutionToDelete.getId());
        institutionRepository.delete(institution);
    }
}
