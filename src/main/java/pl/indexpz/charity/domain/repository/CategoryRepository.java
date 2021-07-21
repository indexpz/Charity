package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCategoryName(String categoryName);

}

