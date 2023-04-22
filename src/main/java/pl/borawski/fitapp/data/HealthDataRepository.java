package pl.borawski.fitapp.data;

import org.springframework.data.repository.CrudRepository;
import pl.borawski.fitapp.user.User;

import java.util.List;
import java.util.Optional;

public interface HealthDataRepository extends CrudRepository<HealthDataEntity, Long> {
    List<HealthDataEntity> findAllByUser(User user);
}
