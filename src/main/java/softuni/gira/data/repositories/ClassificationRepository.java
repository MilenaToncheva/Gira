package softuni.gira.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gira.data.entities.ClassificationEntity;

@Repository
public interface ClassificationRepository extends JpaRepository<ClassificationEntity,String> {
}
