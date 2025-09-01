package com.example.bookify_service.controllers;

import com.example.bookify_service.models.Booking;
import com.example.bookify_service.models.TimeSlot;
import com.example.bookify_service.models.AppUser;
import com.example.bookify_service.repositories.TimeSlotRepository;
import com.example.bookify_service.repositories.UserRepository;
import com.example.bookify_service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Map<String, Long> request) {
        Long clientId = request.get("clientId");
        Long timeSlotId = request.get("timeSlotId");
        Booking booking = bookingService.createBooking(clientId, timeSlotId);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/providers/{providerId}/slots")
    public ResponseEntity<List<TimeSlot>> getAvailableSlots(@PathVariable Long providerId) {
        AppUser provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        List<TimeSlot> availableSlots = timeSlotRepository.findByProviderAndIsBookedFalse(provider);
        return ResponseEntity.ok(availableSlots);
    }
}