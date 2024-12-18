package com.example.taskproject.service;
import com.example.taskproject.payload.TaskDto;

import java.util.List;

public interface TaskService {
    public TaskDto saveTask(long userid,TaskDto taskDto);


    public List<TaskDto> getAllTasks(long userid);

    // New methods
    TaskDto getTaskById(long taskId);
    TaskDto updateTask(long taskId, TaskDto taskDto);
    void deleteTask(long taskId);

}
