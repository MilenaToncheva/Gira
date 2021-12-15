package softuni.gira.service;

import softuni.gira.service.models.TaskServiceModel;

import java.util.List;

public interface TaskService {
    List<TaskServiceModel> getAllTasks();
}
