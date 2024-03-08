package et.com.taskmanager.controller;

import et.com.taskmanager.model.Task;
import et.com.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }

    @DeleteMapping("/{taskName}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskName) {
        taskService.deleteTask(taskName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{taskName}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable String taskName) {
        Task updatedTask = taskService.markTaskAsCompleted(taskName);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}
