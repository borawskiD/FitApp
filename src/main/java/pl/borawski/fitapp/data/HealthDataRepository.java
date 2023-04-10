package pl.borawski.fitapp.data;

import org.springframework.data.repository.CrudRepository;

public interface HealthDataRepository extends CrudRepository<HealthDataEntity, Long> {
}
