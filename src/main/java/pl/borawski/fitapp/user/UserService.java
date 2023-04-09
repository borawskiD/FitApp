package pl.borawski.fitapp.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserVerifyDTO> findUserByMail(String email) {
        return userRepository.findUserByMail(email)
                .map(UserVerifyMapper::map);
    }

    @Transactional
    public void register(UserRegisterDTO registration) {

//        private String mail;
//        private String name;
//        private String password;
//        private String birthDate;
//        private double weight;
//        private double height;
//        private String Gender;
//        private String activityLevel;


        User user = new User();
        user.setName(registration.getName());
        user.setMail(registration.getMail());
        String passwordHash = passwordEncoder.encode(registration.getPassword());
        user.setPassword(passwordHash);
        user.setBirthDate(registration.getBirthDate());
        user.setWeight(registration.getWeight());
        user.setHeight(registration.getHeight());
        user.setGender(registration.getGender());
        user.setActivityLevel(registration.getActivityLevel());
        userRepository.save(user);
    }

}