package softuni.gira.service.impl;

import org.springframework.stereotype.Service;
import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.repositories.ClassificationRepository;
import softuni.gira.service.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
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
}
