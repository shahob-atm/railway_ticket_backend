package com.example.railway_ticket_backend.entity.train;

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
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private TrainType trainType;

    @Column(nullable = false)
    private Double speed;

    @Column(nullable = false)
    private Integer capacity;
}
