package com.example.MyStore.controllers;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    private int id;
    private String firstName;
 }