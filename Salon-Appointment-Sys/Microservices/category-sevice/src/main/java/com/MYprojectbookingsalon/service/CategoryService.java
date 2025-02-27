package com.MYprojectbookingsalon.service;

import java.util.Set;

import com.MYprojectbookingsalon.modal.Category;
import com.MYprojectbookingsalon.payload.dto.SalonDTO;

public interface CategoryService {
    
    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoriesBySalon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryBYId(Long id,Long salonId) throws Exception;

}
