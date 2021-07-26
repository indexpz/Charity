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
import java.util.Optional;

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
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Optional<Donation> getDonationById(Long donationId) {
        return donationRepository.findById(donationId);
    }

    @Override
    public Donation getDonationByInstitution(Institution institutionId) {
//        Donation donation = institutionRepository.findById(institutionId).
        return null;
    }

    @Override
    public void updateDonation(Donation donationToUpdate) {
        Optional<Donation> optionalDonation = getDonationById(donationToUpdate.getId());
        if (optionalDonation.isPresent()) {
            Donation donation = optionalDonation.get();
            donation.setQuantity(donationToUpdate.getQuantity());
            donation.setName(donationToUpdate.getName());
            donation.setStreet(donationToUpdate.getStreet());
            donation.setCity(donationToUpdate.getCity());
            donation.setZipCode(donationToUpdate.getZipCode());
            donation.setPickUpDate(donationToUpdate.getPickUpDate());
            donation.setPickUpTime(donationToUpdate.getPickUpTime());
            donation.setPickUpComment(donationToUpdate.getPickUpComment());
            donationRepository.save(donation);
        }else {
            Donation donation = new Donation();
    }

}

    @Override
    public void deleteDonation(Donation donationToDelete) {
        Optional<Donation> optionalDonation = getDonationById(donationToDelete.getId());
        if (optionalDonation.isPresent()) {
            Donation donation = optionalDonation.get();
            donationRepository.delete(donation);
        }else {
            Donation donation = new Donation();
        }
    }

    @Override
    public int getNumberOfDonations() {
        return getAllDonations().size();
    }

    @Override
    public int getNumberOfBags() {
        int result = 0;
        for (Donation d : getAllDonations()) {
            result += d.getQuantity();
        }
        return result;
    }

}
