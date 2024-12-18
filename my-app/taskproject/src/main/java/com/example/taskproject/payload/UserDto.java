package com.example.taskproject.payload;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {


    private long id;
    private String name;
    private String email;
    private String password;

}
