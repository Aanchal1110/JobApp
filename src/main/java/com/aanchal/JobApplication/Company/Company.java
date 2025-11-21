package com.aanchal.JobApplication.Company;

import com.aanchal.JobApplication.Jobs.Jobs;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Jobs> jobs;

   // private List<Review> reviews;

    public Company() {
    }

    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
