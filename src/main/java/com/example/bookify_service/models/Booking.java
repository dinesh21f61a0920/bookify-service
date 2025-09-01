package com.example.bookify_service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private AppUser client;

    @OneToOne
    @JoinColumn(name = "timeslot_id", nullable = false)
    private TimeSlot slot;

    public Booking(AppUser client, TimeSlot slot) {
        this.client = client;
        this.slot = slot;
    }
}