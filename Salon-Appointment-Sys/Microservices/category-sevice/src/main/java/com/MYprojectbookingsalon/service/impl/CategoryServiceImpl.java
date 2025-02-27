package com.MYprojectbookingsalon.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.MYprojectbookingsalon.modal.Category;
import com.MYprojectbookingsalon.payload.dto.SalonDTO;
import com.MYprojectbookingsalon.repo.CategoryRepository;
import com.MYprojectbookingsalon.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(salonDTO.getId());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            throw new Exception("Category not exist with id: " + id);
        }
        return category;

    }

    @Override
    public void deleteCategoryBYId(Long id,Long salonId) throws Exception {

        Category category=getCategoryById(id);
        if(!category.getSalonId().equals(salonId)){
            throw new Exception("Category not exist with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

}
