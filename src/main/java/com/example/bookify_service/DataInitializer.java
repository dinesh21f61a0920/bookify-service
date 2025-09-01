package com.example.bookify_service;

import com.example.bookify_service.models.TimeSlot;
import com.example.bookify_service.models.AppUser;
import com.example.bookify_service.repositories.TimeSlotRepository;
import com.example.bookify_service.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TimeSlotRepository timeSlotRepository;

    public DataInitializer(UserRepository userRepository, TimeSlotRepository timeSlotRepository) {
        this.userRepository = userRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only add the initial data if the user table is empty
        if (userRepository.count() == 0) {
            AppUser provider = new AppUser();
            provider.setName("Dr. Ishan Singh");
            provider.setEmail("ishan.singh@clinic.com");
            provider.setRole("PROVIDER");
            userRepository.save(provider); // Provider will have ID 1

            AppUser client = new AppUser();
            client.setName("Priya Kumar");
            client.setEmail("priya.kumar@email.com");
            client.setRole("CLIENT");
            userRepository.save(client); // Client will have ID 2

            TimeSlot slot = new TimeSlot();
            slot.setProvider(provider);
            slot.setStartTime(LocalDateTime.of(2025, 10, 15, 14, 0));
            slot.setEndTime(LocalDateTime.of(2025, 10, 15, 15, 0));
            slot.setBooked(false);
            timeSlotRepository.save(slot); // Slot will have ID 1

            System.out.println("---- Test Data Initialized ----");
            System.out.println("Provider ID: 1, Client ID: 2, TimeSlot ID: 1");
        } else {
            System.out.println("---- Database already contains data. Skipping initialization. ----");
        }
    }
}