package softuni.gira.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gira.data.entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,String> {
}
