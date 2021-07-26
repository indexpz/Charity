package pl.indexpz.charity.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.model.Donation;
import pl.indexpz.charity.domain.model.Institution;
import pl.indexpz.charity.domain.repository.CategoryRepository;
import pl.indexpz.charity.domain.service.CategoryServiceInterface;
import pl.indexpz.charity.domain.service.DonationServiceInterface;
import pl.indexpz.charity.domain.service.InstitutionServiceInterface;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataSetup {

    private final CategoryServiceInterface categoryServiceInterface;
    private final DonationServiceInterface donationServiceInterface;
    private final InstitutionServiceInterface institutionServiceInterface;


    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {
            System.out.println("Aplikacja właśnie się uruchomiła i rozpoczynamy zabawę");
        }
    }

    @PostConstruct
    @Transactional
    public void setUpData() {
        createCategoryIfNotExist(1L, "ubrania, które nadają się do ponownego użycia");
        createCategoryIfNotExist(2L, "ubrania, do wyrzucenia");
        createCategoryIfNotExist(3L, "zabawki");
        createCategoryIfNotExist(4L, "książki");

        createDonationIfNotExist(1L, "Pierwsza darowizna", 1, "Pierwsza", null, null, null, null, null);
        createDonationIfNotExist(2L, "Druga darowizna", 2, "Druga", null, null, null, null, null);
        createDonationIfNotExist(3L, "Trzecia darowizna", 3, "Trzecia", null, null, null, null, null);



        createInstitutionIfNotExist(1L, "Fundacja \"Dbam o Zdrowie\"", "Pomoc dzieciom z ubogich rodzin.");
        createInstitutionIfNotExist(2L, "Fundacja \"Dla dzieci\"", "Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
        createInstitutionIfNotExist(3L, "Fundacja \"A kogo\"", "Pomoc wybudzaniu dzieci ze śpiączki.");
        createInstitutionIfNotExist(4L, "Fundacja \"Bez domu\"", "Pomoc dla osób nie posiadających miejsca zamieszkania.");
    }

    private void createCategoryIfNotExist(Long id, String name) {
        if(categoryServiceInterface.getCategoryById(id).isPresent()){
            log.debug("Category o id {} istnieje w bazie danych. Nie potrzeba dodawać", id);
        }else{
            Category category = new Category(id, name);
            categoryServiceInterface.addCategory(category);
            log.debug("Dodano Category do bd {}", category);
        }

    }

    private void createDonationIfNotExist(Long id, String name, Integer quantity, String street, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        if(donationServiceInterface.getDonationById(id).isPresent()){
            log.debug("Donation o id {} istnieje w bazie danych. Nie potrzeba dodawać", id);
        }else{
            Donation donation = new Donation(null, name, quantity, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, null, null);
            donationServiceInterface.addDonation(donation);
            log.debug("Dodano Doantion do bd {}", donation);
        }
    }


    private void createInstitutionIfNotExist(Long id, String name, String description) {
      if( institutionServiceInterface.getInstitutionById(id).isPresent()){
          log.debug("Institution o id {} istnieje w bazie danych. Nie potrzeba dodawać", id);
      }else {
          Institution institution = new Institution(id, name, description);
          institutionServiceInterface.addInstitution(institution);
          log.debug("Dodano Category do bd {}", institution);
      }


    }

}
