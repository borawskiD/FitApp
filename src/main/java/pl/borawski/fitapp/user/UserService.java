package pl.borawski.fitapp.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserVerifyDTO> findUserByMail(String email) {
        return userRepository.findUserByMail(email)
                .map(UserVerifyMapper::map);
    }
}