package et.com.taskmanager.repository;

import et.com.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategory(String category);
    List<Task> findByCompleted(boolean completed);
    Optional<Task> findByName(String name);
    void deleteByName(String name);
}
