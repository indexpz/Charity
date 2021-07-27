package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.charity.domain.model.Category;
import pl.indexpz.charity.domain.repository.CategoryRepository;
import pl.indexpz.charity.domain.service.CategoryServiceInterface;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //zamiast konstruktora
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category addCategory(Category categoryToAdd) {
        return categoryRepository.save(categoryToAdd);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return category;
    }



    @Override
    public void updateCategory(Category categoryToUpdate) {
        Optional<Category> optionalCategory = getCategoryById(categoryToUpdate.getId());
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(category.getName());
            categoryRepository.save(category);
        }else{
            Category category = new Category();
        }


    }

    @Override
    public void deleteCategory(Category categoryToDelete) {
        Optional<Category> optionalCategory = getCategoryById(categoryToDelete.getId());
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            categoryRepository.delete(category);
        }else{
            Category category = new Category();
        }

    }
}
