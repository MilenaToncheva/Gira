package softuni.gira.mapping;

import org.mapstruct.Mapper;
import softuni.gira.data.entities.UserEntity;
import softuni.gira.service.models.UserServiceModel;
import softuni.gira.web.models.UserRegisterBindingModel;

@Mapper(componentModel = "spring")
public interface    UserMapper {
    UserServiceModel mapUserRegisterBindingModelToUserServiceModel(UserRegisterBindingModel userRegisterBindingModel);
    UserEntity mapUserServiceModelToUserEntity(UserServiceModel userServiceModel);
    UserServiceModel mapUserEntityToUserServiceModel(UserEntity userEntity);
}
