package softuni.gira.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface GiraSecurityUserService {
   UserDetails loadUserByUsername(String username);


}
