package com.MYprojectbookingsalon.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MYprojectbookingsalon.modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Long > {
    Set<Category> findBySalonId(Long salonId);
    
}
