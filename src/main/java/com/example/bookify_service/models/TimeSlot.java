package com.example.bookify_service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private AppUser provider;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isBooked = false;
}