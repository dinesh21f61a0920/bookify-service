package com.example.bookify_service.repositories;

import com.example.bookify_service.models.AppUser;
import com.example.bookify_service.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByProviderAndIsBookedFalse(AppUser provider);
}