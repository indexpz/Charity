package pl.indexpz.charity.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.repository.CategoryRepository;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataSetup {

    private  final CategoryRepository categoryRepository;

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event){
        if(!alreadyRun.getAndSet(true)){
            System.out.println("Aplikacja właśnie się uruchomiła i rozpoczynamy zabawę");
        }
    }

    @PostConstruct
    @Transactional
    public void setUpData(){
        createCategoryIfNotExist(1L, "ubrania, które nadają się do ponownego użycia");
        createCategoryIfNotExist(2L, "ubrania, do wyrzucenia");
        createCategoryIfNotExist(3L, "zabawki");
        createCategoryIfNotExist(4L, "książki");
        createCategoryIfNotExist(5L, "inne");
    }

    private void createCategoryIfNotExist(Long id, String name){
        try{
            categoryRepository.findById(id);
            log.debug("Category o id {} istnieje w bazie danych. Nie potrzeba dodawać", id);
        }catch (ResourceNotFoundException e){
            Category category = new Category(null, name);
            categoryRepository.save(category);
            log.debug("Dodano Category do bd {}", category);
        }
    }

}
