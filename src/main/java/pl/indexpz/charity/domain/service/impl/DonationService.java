package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.repository.DonationRepository;
import pl.indexpz.charity.domain.repository.InstitutionRepository;
import pl.indexpz.charity.domain.service.InterfaceDonationService;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor //zamiast konstruktora
public class DonationService implements InterfaceDonationService {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    @Override
    @Transactional
    public Donation addDonation(Donation donationToAdd) {
        return donationRepository.save(donationToAdd);
    }

    @Override
    public Donation getDonationById(Long donationId) {
        return donationRepository.findById(donationId).orElseThrow((()->new ResourceNotFoundException("Donation with id " + donationId + " not exist.")));
    }

    @Override
    public Donation getDonationByInstitution(Institution institutionId) {
//        Donation donation = institutionRepository.findById(institutionId).
        return null;
    }

    @Override
    public void updateDonation(Donation donationToUpdate) {

    }

    @Override
    public void deleteDonation(Donation donationToDelete) {

    }
}
