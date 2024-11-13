package com.example.FamilyMember;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Entity
public class UserRepository
        private Long id;

public Long getId() {
            return id;
        }

public void setId(Long id) {
            this.id = id;
        }

private Long id;

public Long getId() {
            return id;
        }

public void setId(Long id) {
            this.id = id;
        }

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    private String role = "USER"; // Default role

    // Getters and Setters

    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
    }
}
