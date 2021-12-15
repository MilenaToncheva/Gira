package softuni.gira.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class GiraSecurityUser extends User {
   // public GiraSecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
   //     super(email, password, authorities);
   // }
//
   // public GiraSecurityUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
   //     super(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
   // }

    public GiraSecurityUser(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
    }

    public GiraSecurityUser(String email, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
