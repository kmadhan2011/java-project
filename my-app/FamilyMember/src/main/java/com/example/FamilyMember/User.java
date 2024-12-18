package com.example.FamilyMember;


import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private Long id;

    private String name;

    private String email;
}

