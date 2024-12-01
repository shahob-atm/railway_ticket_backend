package com.example.railway_ticket_backend.entity.coach;

import com.example.railway_ticket_backend.entity.train.Train;
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
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Train train;

    @Column(nullable = false)
    private Integer coachNumber;

    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    @Column(nullable = false)
    private Integer capacity;
}
