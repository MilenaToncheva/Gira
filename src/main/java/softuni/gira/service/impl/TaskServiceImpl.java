package softuni.gira.service.impl;

import org.springframework.stereotype.Service;
import softuni.gira.data.repositories.TaskRepository;
import softuni.gira.mapping.TaskMapper;
import softuni.gira.service.TaskService;
import softuni.gira.service.models.TaskServiceModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;

        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskServiceModel> getAllTasks() {
       return this.taskRepository.findAll().stream().map(this.taskMapper::mapTaskEntityToTaskServiceModel)
               .collect(Collectors.toList());

    }
}
