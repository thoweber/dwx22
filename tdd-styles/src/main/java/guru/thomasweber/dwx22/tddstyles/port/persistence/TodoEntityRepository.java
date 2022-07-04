package guru.thomasweber.dwx22.tddstyles.port.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoEntityRepository extends CrudRepository<TodoEntity, String> {

}
