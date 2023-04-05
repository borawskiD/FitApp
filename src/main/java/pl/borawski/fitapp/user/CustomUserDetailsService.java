package pl.borawski.fitapp.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.borawski.fitapp.user.UserService;
import pl.borawski.fitapp.user.UserVerifyDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return userService.findUserByMail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with this email doesn't exits"));
    }
    private UserDetails createUserDetails(UserVerifyDTO credentials) {
        System.out.println(credentials);
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .roles("USER")
                .build();
    }
}
