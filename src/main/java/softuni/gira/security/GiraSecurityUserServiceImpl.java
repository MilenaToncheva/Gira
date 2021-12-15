package softuni.gira.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.gira.data.entities.UserEntity;
import softuni.gira.data.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiraSecurityUserServiceImpl implements GiraSecurityUserService, UserDetailsService {
    private final UserRepository userRepository;

    public GiraSecurityUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   // @Override
  // public UserDetails loadUserByUsername(String username) {
  //     UserEntity user = this.userRepository.findByUsername(username)
  //             .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + "not found"));
  //     return mapToUserDetails(user);
  // }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        List<GrantedAuthority> grantedAuthorities = userEntity
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());
        return new GiraSecurityUser(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user=this.userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with email " + email + "not found"));
    return mapToUserDetails(user);
    }
}
