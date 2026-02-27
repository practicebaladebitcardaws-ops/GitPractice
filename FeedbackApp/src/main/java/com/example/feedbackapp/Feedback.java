package com.example.feedbackapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "areas_to_improve", length = 1000)
    private String areasToImprove;

    @Column(nullable = false)
    private int rating; // 1-5
}
