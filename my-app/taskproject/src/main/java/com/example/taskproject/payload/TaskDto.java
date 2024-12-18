package com.example.taskproject.payload;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TaskDto {
    private long id;
    private String taskName;
    private String description;
}
