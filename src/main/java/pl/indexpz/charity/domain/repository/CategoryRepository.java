package pl.indexpz.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.charity.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByName(String name);
}

