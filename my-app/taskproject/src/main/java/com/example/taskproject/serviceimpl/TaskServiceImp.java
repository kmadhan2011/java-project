package com.example.taskproject.serviceimpl;

import com.example.taskproject.entity.Task;
import com.example.taskproject.entity.Users;
import com.example.taskproject.exception.UserNotFound;
import com.example.taskproject.payload.TaskDto;
import com.example.taskproject.repository.TaskRepository;
import com.example.taskproject.repository.UserRepository;
import com.example.taskproject.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) {
        // Find the user by userId
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        // Map TaskDto to Task entity
        Task task = modelMapper.map(taskDto, Task.class);

        // Set the user in the Task entity
        task.setUser(user);

        // Save the task to the database
        Task savedTask = taskRepository.save(task);

        // Map the saved Task entity back to TaskDto and return it
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userId) {
        // Check if the user exists
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        // Fetch all tasks for the given user
        List<Task> tasks = taskRepository.findByUser(user);

        // Map the Task entities to TaskDto list and return it
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    // 1. Get an individual task by its ID
    @Override
    public TaskDto getTaskById(long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task with ID " + taskId + " not found"));
        return modelMapper.map(task, TaskDto.class);
    }

    // 2. Update/Edit an individual task
    @Override
    public TaskDto updateTask(long taskId, TaskDto taskDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task with ID " + taskId + " not found"));

        // Update task details
        task.setTaskName(taskDto.getTaskName());
        task.setDescription(taskDto.getDescription());

        Task updatedTask = taskRepository.save(task);
        return modelMapper.map(updatedTask, TaskDto.class);
    }

    // 3. Delete an individual task
    @Override
    public void deleteTask(long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task with ID " + taskId + " not found"));
        taskRepository.delete(task);
    }
}
