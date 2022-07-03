package guru.thomasweber.dwx22.tddstyles.port.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoEntityRepository extends CrudRepository<TodoEntity, UUID> {

}
