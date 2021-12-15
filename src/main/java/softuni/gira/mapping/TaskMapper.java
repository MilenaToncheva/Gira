package softuni.gira.mapping;

import org.mapstruct.Mapper;
import softuni.gira.data.entities.TaskEntity;
import softuni.gira.service.models.TaskServiceModel;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskServiceModel mapTaskEntityToTaskServiceModel(TaskEntity taskEntity);
}
