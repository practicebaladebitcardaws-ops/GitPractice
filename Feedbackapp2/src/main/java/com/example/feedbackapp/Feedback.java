package com.example.feedbackapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @NotBlank
    private String location;

    @NotBlank
    private String organizationName;

    private String areasToImprove;

    @Min(1)
    @Max(5)
    private int rating;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    public String getAreasToImprove() { return areasToImprove; }
    public void setAreasToImprove(String areasToImprove) { this.areasToImprove = areasToImprove; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
