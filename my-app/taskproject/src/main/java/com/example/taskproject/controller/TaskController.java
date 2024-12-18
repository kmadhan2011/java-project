package com.example.taskproject.controller;


import com.example.taskproject.payload.TaskDto;
import com.example.taskproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //save the task
    @PostMapping("/{userid}/tasks")
    public ResponseEntity<TaskDto> saveTask(
            @PathVariable(name = "userid")long userid,
            @RequestBody TaskDto taskDto
    ) {
        return new ResponseEntity<>(taskService.saveTask(userid, taskDto), HttpStatus.CREATED);
    }
    //get all task
    @GetMapping("/{userid}/tasks")
     //this is a GET request, it will return a list of tasks for a specific user.
    public ResponseEntity<List<TaskDto>> getAllTasks(
            @PathVariable(name = "userid")long userid

                ) {
        return new ResponseEntity<>(taskService.getAllTasks(userid),HttpStatus.OK);
    }


//    @Autowired
//    private TaskService taskService;

    // 1. Get an individual task by its ID
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "taskId") long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    // 2. Update/Edit an individual task
    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable(name = "taskId") long taskId,
            @RequestBody TaskDto taskDto
    ) {
        TaskDto updatedTask = taskService.updateTask(taskId, taskDto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // 3. Delete an individual task
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "taskId") long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    }
}
