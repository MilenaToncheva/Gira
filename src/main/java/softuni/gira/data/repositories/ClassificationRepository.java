package softuni.gira.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.gira.data.entities.ClassificationEntity;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.service.models.ClassificationServiceModel;

@Repository
public interface ClassificationRepository extends JpaRepository<ClassificationEntity,String> {
    @Query("SELECT c FROM ClassificationEntity c WHERE c.classificationName=:classificationEnum")
    ClassificationEntity findByName(ClassificationEnum classificationEnum);
}
