package guru.thomasweber.dwx22.tddstyles.port.persistence;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoUseCase;
import guru.thomasweber.dwx22.tddstyles.domain.State;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTodoUseCaseImpl implements CreateTodoUseCase {

    private final TodoEntityRepository repository;

    @Override
    public Todo create(CreateTodoCommand createCommand) {
        TodoEntity entity = TodoEntity.builder()
                .id(UUID.randomUUID())
                .name(createCommand.getName())
                .dueDate(createCommand.getDueDate())
                .state(State.OPEN)
                .build();
        return repository.save(entity);
    }
}
