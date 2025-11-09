package com.sanasa.trainingtracker.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @JsonManagedReference
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonManagedReference
    private Training training;

    private String status; // e.g. "Attended"
}

