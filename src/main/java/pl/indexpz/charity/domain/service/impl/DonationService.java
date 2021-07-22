package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.repository.DonationRepository;
import pl.indexpz.charity.domain.repository.InstitutionRepository;
import pl.indexpz.charity.domain.service.DonationServiceInterface;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor //zamiast konstruktora
public class DonationService implements DonationServiceInterface {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    @Override
    @Transactional
    public Donation addDonation(Donation donationToAdd) {
        return donationRepository.save(donationToAdd);
    }

    @Override
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation getDonationById(Long donationId) {
        return donationRepository.findById(donationId).orElseThrow((() -> new ResourceNotFoundException("Donation with id " + donationId + " not exist.")));
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

    @Override
    public int getNumberOfDonations() {
        return getDonations().size();
    }

    @Override
    public int getNumberOfBags() {
        int result = 0;
        for (Donation d: getDonations()) {
            result += d.getQuantity();
        }
        return result;
    }

}
