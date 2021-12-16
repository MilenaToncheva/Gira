package softuni.gira.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import softuni.gira.service.models.TaskServiceModel;

import java.util.List;

public interface TaskService {
    List<TaskServiceModel> getAllTasks();

    void saveTask(TaskServiceModel taskServiceModel);

    void updateProgress(String id) throws ChangeSetPersister.NotFoundException;
}
