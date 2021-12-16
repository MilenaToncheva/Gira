package softuni.gira.service.impl;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import softuni.gira.data.entities.TaskEntity;
import softuni.gira.data.enums.ProgressEnum;
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

    @Override
    public void saveTask(TaskServiceModel taskServiceModel) {
        TaskEntity taskEntity = this.taskMapper.mapTaskServiceModelToTaskEntity(taskServiceModel);
        this.taskRepository.save(taskEntity);
    }

    @Override
    public void updateProgress(String id) {
        TaskEntity taskEntity=this.taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

        switch (taskEntity.getProgress().name()){
            case "OPEN":
                taskEntity.setProgress(ProgressEnum.IN_PROGRESS);
                this.taskRepository.save(taskEntity);
                break;
            case "IN_PROGRESS":
                taskEntity.setProgress(ProgressEnum.COMPLETED);
                this.taskRepository.save(taskEntity);
                break;
            default:
                this.taskRepository.delete(taskEntity);
                break;
        }
    }
}
