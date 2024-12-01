package com.example.railway_ticket_backend.entity.layoutElement;

import com.example.railway_ticket_backend.entity.coachLayout.CoachLayout;
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
public class LayoutElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CoachLayout coachLayout;

    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    private Integer x;

    private Integer y;
}
