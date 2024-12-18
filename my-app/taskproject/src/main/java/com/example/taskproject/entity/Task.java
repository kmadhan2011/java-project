package com.example.taskproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // Many tasks can belong to one user
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
