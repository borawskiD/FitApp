package pl.borawski.fitapp.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.borawski.fitapp.data.HealthDataEntity;
import pl.borawski.fitapp.data.HealthDataRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final HealthDataRepository healthDataRepository;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, HealthDataRepository healthDateRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.healthDataRepository = healthDateRepository;
    }
    public Optional<UserVerifyDTO> findUserByMail(String email) {
        return userRepository.findUserByMail(email)
                .map(UserVerifyMapper::map);
    }

    @Transactional
    public void register(UserRegisterDTO registration) {
        String passwordHash = passwordEncoder.encode(registration.getPassword());
        User user = new User(registration.getMail(), passwordHash,registration.getName(),registration.getBirthDate(),LocalDateTime.now());
        userRepository.save(user);
        HealthDataEntity healthDataEntity = new HealthDataEntity(registration.getWeight(), registration.getHeight(), registration.getGender(), registration.getActivityLevel(), LocalDateTime.now(), user);
        healthDataRepository.save(healthDataEntity);

    }

}