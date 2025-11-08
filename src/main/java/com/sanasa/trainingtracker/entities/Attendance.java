package com.sanasa.trainingtracker.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private TrainingProgram trainingProgram;

    @Column(nullable = false)
    private String status; // Present, Absent, Excused

    private String remarks;

    private LocalDate attendanceDate;
}
