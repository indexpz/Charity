package pl.indexpz.charity.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Category;

import java.util.List;

@Service
@Repository
@Transactional
public interface CategoryServiceInterface {

    Category addCategory(Category categoryToAdd);

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category getCategoryByName(String categoryName);

    public void updateCategory(Category categoryToUpdate);

    public void deleteCategory(Category categoryToDelete);

}
