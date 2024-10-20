package com.pluralsight.springboot.events;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Marks this class as a JPA entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-generated primary key
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Many events can have the same organizer
    @JoinColumn(name = "organizer_id", referencedColumnName = "id", nullable = false) // Specifies foreign key column
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY) // Many events can take place at the same venue
    @JoinColumn(name = "venue_id", referencedColumnName = "id", nullable = false) // Specifies foreign key column
    private Venue venue;

    private LocalDate startDate;

    private LocalDate endDate;
}
