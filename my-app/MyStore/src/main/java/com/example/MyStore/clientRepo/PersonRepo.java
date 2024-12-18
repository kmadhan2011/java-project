package com.example.MyStore.clientRepo;

import com.example.MyStore.controllers.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Client,Long> {
}
