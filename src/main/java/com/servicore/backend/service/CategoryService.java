package com.servicore.backend.service;

import com.servicore.backend.entity.Category;
import com.servicore.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository =categoryRepository;
    }

    public Category saveCategory(Category category) {
        if (category.getId() == null) {
            categoryRepository.findByName(category.getName())
                    .ifPresent(c -> { throw new RuntimeException("Esa categoría ya existe"); });
        }
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryByID(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("categoria no encontrada"));
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
    }
}
