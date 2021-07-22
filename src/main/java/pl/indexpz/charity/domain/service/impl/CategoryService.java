package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.repository.CategoryRepository;
import pl.indexpz.charity.domain.service.InterfaceCategoryService;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor //zamiast konstruktora
public class CategoryService implements InterfaceCategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category addCategory(Category categoryToAdd) {
        return categoryRepository.save(categoryToAdd);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow((() -> new ResourceNotFoundException("Category with id " + categoryId + " not exist.")));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return category;
    }

    @Override
    public void updateCategory(Category categoryToUpdate) {
        Category category = getCategoryById(categoryToUpdate.getId());
        category.setName(category.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category categoryToDelete) {
        Category category = getCategoryById(categoryToDelete.getId());
        categoryRepository.delete(category);
    }
}
