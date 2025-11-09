package com.sanasa.trainingtracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String epfCode;
    private String nicNumber;
    private String branch;
    private String province;
    private String email;
    private String status = "Active"; // optional default

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Attendance> attendances;
}

