package pl.indexpz.charity.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.model.Institution;

@Service
@Repository
@Transactional
public interface InterfaceDonationService {

    Donation addDonation(Donation donationToAdd);

    Donation getDonationById(Long donationId);

    Donation getDonationByInstitution(Institution institutionId);

    public void updateDonation(Donation donationToUpdate);

    public void deleteDonation(Donation donationToDelete);
}
