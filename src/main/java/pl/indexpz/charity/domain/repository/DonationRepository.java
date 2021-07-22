package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
