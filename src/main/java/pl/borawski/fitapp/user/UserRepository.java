package pl.borawski.fitapp.user;

import org.springframework.data.repository.CrudRepository;
import pl.borawski.fitapp.user.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByMail(String mail);
    Optional<Long> findIdByMail(String mail);
}
