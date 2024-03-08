package et.com.taskmanager.service;

import et.com.taskmanager.model.Task;
import et.com.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(String taskName) {
        Task task = taskRepository.findByName(taskName).get();
        taskRepository.deleteById(task.getId());
    }

    public Task markTaskAsCompleted(String taskName) {
        Optional<Task> optionalTask = taskRepository.findByName(taskName);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(true);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task with id " + taskName + " not found");
        }
    }
}
