package softuni.gira.mapping;

import org.mapstruct.Mapper;
import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.service.models.ClassificationServiceModel;

@Mapper(componentModel = "spring")
public interface ClassificationMapper {
    ClassificationServiceModel mapClassificationEntityToClassificationServiceModel(ClassificationEntity classificationEntity);
}
