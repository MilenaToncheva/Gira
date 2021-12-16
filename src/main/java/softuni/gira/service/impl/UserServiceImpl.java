package softuni.gira.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.gira.data.entities.RoleEntity;
import softuni.gira.data.entities.UserEntity;
import softuni.gira.data.enums.RoleEnum;
import softuni.gira.data.repositories.RoleRepository;
import softuni.gira.data.repositories.UserRepository;
import softuni.gira.mapping.UserMapper;
import softuni.gira.service.UserService;
import softuni.gira.service.models.UserServiceModel;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isUsernameFree(String username) {
        return this.userRepository.findByUsername(username).isEmpty();

    }

    @Override
    public boolean isEmailUnique(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        Set<RoleEntity> roles = new HashSet<>();
        if (this.userRepository.count() == 0) {
            roles.addAll(this.roleRepository.findAll());
        } else {
            roles.add(this.roleRepository.findByRole(RoleEnum.USER));
        }
        UserEntity userEntity = this.userMapper.mapUserServiceModelToUserEntity(userServiceModel);
        userEntity.setPassword(this.passwordEncoder.encode(userServiceModel.getPassword()));
        userEntity.setRoles(roles);
        this.userRepository.save(userEntity);
    }



    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userMapper.mapUserEntityToUserServiceModel(this.userRepository.findByUsername(username).get());
    }


}
