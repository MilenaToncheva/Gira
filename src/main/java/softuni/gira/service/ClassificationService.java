package softuni.gira.service;

import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.service.models.ClassificationServiceModel;

public interface ClassificationService {
    void loadClassifications();

    ClassificationServiceModel findByName(ClassificationEnum classificationEnum);
}
