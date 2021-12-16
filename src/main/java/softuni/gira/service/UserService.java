package softuni.gira.service;

import softuni.gira.service.models.UserServiceModel;

public interface UserService {
    boolean isUsernameFree(String username);

    boolean isEmailUnique(String email);

    void register(UserServiceModel userServiceModel);



    UserServiceModel findByUsername(String name);
}
