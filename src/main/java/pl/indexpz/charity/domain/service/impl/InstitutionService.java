package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.repository.InstitutionRepository;
import pl.indexpz.charity.domain.service.InstitutionServiceInterface;

import java.util.List;
import java.util.Optional;

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
    public Optional<Institution> getInstitutionById(Long institutionId) {
        return institutionRepository.findById(institutionId);
    }

    @Override
    public Institution getInstitutionByName(String institutionName) {
        Institution institution = (Institution) institutionRepository.findInstitutionByName(institutionName);
        return institution;
    }

    @Override
    public void updateInstitution(Institution institutionToUpdate) {
        Optional<Institution> optionalInstitution = getInstitutionById(institutionToUpdate.getId());
        if(optionalInstitution.isPresent()){
            Institution institution = optionalInstitution.get();
            institution.setName(institutionToUpdate.getName());
            institution.setDescription(institutionToUpdate.getDescription());
            institutionRepository.save(institution);
        }else {
            Institution institution = new Institution();
        }

    }

    @Override
    public void deleteInstitution(Institution institutionToDelete) {
        Optional<Institution> optionalInstitution = getInstitutionById(institutionToDelete.getId());
        if(optionalInstitution.isPresent()){
            Institution institution = optionalInstitution.get();
            institutionRepository.delete(institution);
        }else{
            Institution institution = new Institution();
        }
    }
}
