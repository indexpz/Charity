package pl.indexpz.charity.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Category;

@Service
@Repository
@Transactional
public interface CategoryService {

    Category addCategory(Category categoryToAdd);

    Category getCategoryById(Long categoryId);

    Category getCategoryByName(String categoryName);

    public void updateCategory(Category categoryToUpdate);

    public void deleteCategory(Category categoryToDelete);
}
