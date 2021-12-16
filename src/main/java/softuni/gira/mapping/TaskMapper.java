package softuni.gira.mapping;

import org.mapstruct.Mapper;
import softuni.gira.data.entities.TaskEntity;
import softuni.gira.service.models.TaskServiceModel;
import softuni.gira.web.models.TaskBindingModel;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskServiceModel mapTaskEntityToTaskServiceModel(TaskEntity taskEntity);
    TaskServiceModel mapTaskBindingModelToTaskServiceModel(TaskBindingModel taskBindingModel);
    TaskEntity mapTaskServiceModelToTaskEntity(TaskServiceModel taskServiceModel);
}
