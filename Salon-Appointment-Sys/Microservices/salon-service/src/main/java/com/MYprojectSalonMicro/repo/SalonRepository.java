package com.MYprojectSalonMicro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MYprojectSalonMicro.modal.Salon;

public interface SalonRepository extends JpaRepository<Salon, Long> {
    Salon findByOwnerId(Long ownerId);
    @Query("SELECT s FROM Salon s WHERE" +
    "(lower(s.city) like lower(concat('%',:Keyword,'%')) OR " +
    "lower(s.name) like lower(concat('%',:Keyword,'%')) OR " +
    "lower(s.address) like lower(concat('%',:Keyword,'%')))"
    )
    List<Salon> searchSalon(@Param("Keyword")String city);
    
}
