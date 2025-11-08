package com.sanasa.trainingtracker.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String designation;  // e.g., Cluster Manager, SPO, etc.

    private String region;
    private String branch;
    private String email;
    private String mobileNo;
    private String status; // Active / Inactive

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonManagedReference
    private Role role;
}
