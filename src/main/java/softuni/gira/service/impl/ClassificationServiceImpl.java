package softuni.gira.service.impl;

import org.springframework.stereotype.Service;
import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.repositories.ClassificationRepository;
import softuni.gira.mapping.ClassificationMapper;
import softuni.gira.service.ClassificationService;
import softuni.gira.service.models.ClassificationServiceModel;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;
private final ClassificationMapper classificationMapper;
    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ClassificationMapper classificationMapper) {
        this.classificationRepository = classificationRepository;
        this.classificationMapper = classificationMapper;
    }

    @Override
    public void loadClassifications() {
        if(this.classificationRepository.count()==0){
            for (ClassificationEnum classification : ClassificationEnum.values()) {
                ClassificationEntity classificationEntity=new ClassificationEntity();
                classificationEntity.setClassificationName(classification);
                classificationEntity.setDescription(classification.name()+" short description");
                this.classificationRepository.save(classificationEntity);
            }
        }
    }

    @Override
    public ClassificationServiceModel findByName(ClassificationEnum classificationEnum) {
      ClassificationEntity classificationEntity=  this.classificationRepository.findByName(classificationEnum);
      ClassificationServiceModel cl=   this.classificationMapper
              .mapClassificationEntityToClassificationServiceModel(this.classificationRepository.findByName(classificationEnum));

    return cl;
    }
}
