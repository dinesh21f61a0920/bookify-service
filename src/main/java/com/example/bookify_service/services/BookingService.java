package com.example.bookify_service.services;

import com.example.bookify_service.models.Booking;
import com.example.bookify_service.models.TimeSlot;
import com.example.bookify_service.models.AppUser;
import com.example.bookify_service.repositories.BookingRepository;
import com.example.bookify_service.repositories.TimeSlotRepository;
import com.example.bookify_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Booking createBooking(Long clientId, Long timeSlotId) {
        TimeSlot slot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new RuntimeException("TimeSlot not found"));

        AppUser client = userRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (slot.isBooked()) {
            throw new RuntimeException("This slot is already booked.");
        }

        slot.setBooked(true);
        timeSlotRepository.save(slot);

        Booking newBooking = new Booking(client, slot);
        return bookingRepository.save(newBooking);
    }
}