package softuni.gira.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gira.data.entities.RoleEntity;
import softuni.gira.data.enums.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,String> {
    RoleEntity findByRole(RoleEnum user);
}
