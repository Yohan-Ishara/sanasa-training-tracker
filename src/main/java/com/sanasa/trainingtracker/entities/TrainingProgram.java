package com.sanasa.trainingtracker.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "training_programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trainingName;

    private String trainingType; // e.g., Leadership, Sales, Insurance Knowledge
    private String description;
    private String trainerName;
    private String venue;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "trainingProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendanceList;
}
