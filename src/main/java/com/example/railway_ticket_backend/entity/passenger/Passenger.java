package com.example.railway_ticket_backend.entity.passenger;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String birthDate;

    @Enumerated(EnumType.STRING)
    private DocType docType;

    @Column(nullable = false)
    private String documentNumber;

    @Column(nullable = false)
    private String documentCountry;
}
